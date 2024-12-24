package github.mundotv789123.raspadmin.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.models.dto.AuthResponseDTO;
import github.mundotv789123.raspadmin.models.dto.LoginRequestDTO;
import github.mundotv789123.raspadmin.services.auth.TokenManagerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenManagerService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(HttpServletResponse response, @RequestParam Map<String, String> body) {
        var login = new LoginRequestDTO(body.get("username"), body.get("password"));
        var token = new UsernamePasswordAuthenticationToken(login.username(), login.password());

        Authentication authenticate;
        try {
            authenticate = this.authenticationManager.authenticate(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponseDTO(ex.getMessage(), null));
        }

        UserModel user = (UserModel) authenticate.getPrincipal();
        String tokenStr = this.tokenService.getToken(user);

        Cookie cookie = new Cookie("token", tokenStr);
        cookie.setPath("/");
        response.addCookie(cookie);

        log.info("Login success");
        return ResponseEntity.ok(new AuthResponseDTO(null, tokenStr));
    }
}
