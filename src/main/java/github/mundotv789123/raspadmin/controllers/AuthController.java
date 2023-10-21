package github.mundotv789123.raspadmin.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import github.mundotv789123.raspadmin.models.dto.LoginRequestDTO;
import github.mundotv789123.raspadmin.services.auth.TokenManagerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenManagerService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(HttpServletResponse response, @RequestParam Map<String, String> body) {
        var login = new LoginRequestDTO(body.get("username"), body.get("password"));

        var token = new UsernamePasswordAuthenticationToken(login.username(), login.password());
        Authentication authenticate;

        try {
            authenticate = this.authenticationManager.authenticate(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(ex.getMessage(), null));
        }

        var user = (UserModel) authenticate.getPrincipal();

        String tokenStr = this.tokenService.getToken(user);  
        Cookie cookie = new Cookie("token", tokenStr);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok(new AuthResponse(null, tokenStr));
    }

    @AllArgsConstructor
    private static class AuthResponse {
        private @Getter String message;
        private @Getter String token;
    }
}