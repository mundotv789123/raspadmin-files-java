package github.mundotv789123.raspadmin.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthResponseDTO {
    private @Getter String message;
    private @Getter String token;
}
