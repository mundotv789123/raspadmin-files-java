package github.mundotv789123.raspadmin.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.mundotv789123.raspadmin.models.messages.responses.SettingsResponse;
import github.mundotv789123.raspadmin.services.app.SettingsAppService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/settings")
public class SettingsController {

    private final SettingsAppService service;

    @GetMapping
    public ResponseEntity<SettingsResponse> getFiles() throws IOException {
        var response = service.getSettings();
        return ResponseEntity.ok(response);
    }

}
