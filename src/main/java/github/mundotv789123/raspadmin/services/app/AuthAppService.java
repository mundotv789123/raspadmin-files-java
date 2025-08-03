package github.mundotv789123.raspadmin.services.app;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.entities.UserEntity;
import github.mundotv789123.raspadmin.models.entities.UserSessionEntity;
import github.mundotv789123.raspadmin.models.messages.enums.LoginTypeEnum;
import github.mundotv789123.raspadmin.models.messages.requests.LoginRequest;
import github.mundotv789123.raspadmin.models.messages.responses.LoginResponse;
import github.mundotv789123.raspadmin.repositories.UserSessionsRepository;
import github.mundotv789123.raspadmin.repositories.UsersRespository;
import github.mundotv789123.raspadmin.services.auth.TokenManagerService;
import github.mundotv789123.raspadmin.services.exceptions.InvalidOperateServiceException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthAppService {

    public int refreshTokenExpireMinutes = 10080; // 7 days

    private final TokenManagerService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserSessionsRepository userSessionsRepository;
    private final UsersRespository usersRespository;

    public LoginResponse login(HttpServletResponse response, LoginRequest request) {
        String token = "";
        UserSessionEntity userSession;
        try {
            if (request.getLoginType().equals(LoginTypeEnum.CREDENTIALS)) {
                var authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
                var authenticate = this.authenticationManager.authenticate(authToken);
                UserEntity user = (UserEntity) authenticate.getPrincipal();
                token = this.tokenService.getUserToken(user);
                userSession = new UserSessionEntity();
                log.info("login success " + user.getUsername());
            } else {
                var calendarNow = Calendar.getInstance();

                var refreshTokenSubject = tokenService.getSubject(request.getToken());
                var sessionResult = userSessionsRepository.findByRefreshTokenAndExpireAtGreaterThan(refreshTokenSubject, calendarNow);

                if (sessionResult.isEmpty()) {
                    throw new BadCredentialsException("Sessão inválida ou expirada");
                }
                
                userSession = sessionResult.get();
                var user = usersRespository.findMainUser();
                token = tokenService.getUserToken(user);

                log.info("token refreshed for user: " + user.getUsername());
            }
        } catch (BadCredentialsException ex) {
            throw new InvalidOperateServiceException(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        var refreshTokenStr = generateRefreshToken();
        userSession.setRefreshToken(refreshTokenStr, refreshTokenExpireMinutes, tokenService.getTokenExpireMinutes());
        var refreshToken = tokenService.getSessionToken(userSession);
        
        userSessionsRepository.save(userSession);

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        log.info("Login success");
        return new LoginResponse(token, refreshToken);
    }

    private String generateRefreshToken() {
        var refreshTokenUUID = UUID.randomUUID().toString();
        try {
            var sha256 = MessageDigest.getInstance("SHA-256");
            BigInteger number = new BigInteger(1, sha256.digest(refreshTokenUUID.getBytes()));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 64) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error(ex);
        }
        return refreshTokenUUID;
    }
}
