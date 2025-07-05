package github.mundotv789123.raspadmin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.mundotv789123.raspadmin.models.messages.requests.LoginRequest;
import github.mundotv789123.raspadmin.models.messages.responses.LoginResponse;
import github.mundotv789123.raspadmin.services.app.AuthAppService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthAppService authAppService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(HttpServletResponse response, @RequestBody @Valid LoginRequest request) {
        var respose = authAppService.login(response, request);
        return ResponseEntity.ok(respose);
    }
}
