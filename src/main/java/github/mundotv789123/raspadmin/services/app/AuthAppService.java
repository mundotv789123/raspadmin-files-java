package github.mundotv789123.raspadmin.services.app;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import github.mundotv789123.raspadmin.models.entities.UserEntity;
import github.mundotv789123.raspadmin.models.messages.requests.LoginRequest;
import github.mundotv789123.raspadmin.models.messages.responses.LoginResponse;
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

    private final AuthenticationManager authenticationManager;
    private final TokenManagerService tokenService;
    
    public LoginResponse login(HttpServletResponse response, LoginRequest request) {
        var token = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        Authentication authenticate;
        try {
            authenticate = this.authenticationManager.authenticate(token);
        } catch (BadCredentialsException ex) {
            throw new InvalidOperateServiceException(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        UserEntity user = (UserEntity) authenticate.getPrincipal();
        String tokenStr = this.tokenService.getToken(user);

        Cookie cookie = new Cookie("token", tokenStr);
        cookie.setPath("/");
        response.addCookie(cookie);

        log.info("Login success");
        return new LoginResponse(tokenStr);
    }
}
