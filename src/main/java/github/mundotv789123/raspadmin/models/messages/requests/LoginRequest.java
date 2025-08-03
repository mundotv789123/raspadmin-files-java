package github.mundotv789123.raspadmin.models.messages.requests;

import github.mundotv789123.raspadmin.models.messages.enums.LoginTypeEnum;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginRequest {
    @NotNull
    private @Getter LoginTypeEnum loginType;

    private @Getter String username;
    private @Getter String password;
    private @Getter String token;

    public LoginRequest(String username, String password) {
        this.loginType = LoginTypeEnum.CREDENTIALS;
        this.username = username;
        this.password = password;
    }

    public LoginRequest(String token) {
        this.loginType = LoginTypeEnum.REFRESH_TOKEN;
        this.token = token;
    }

    @AssertTrue(message = "username is required when loginType is 'CREDENTIALS'")
    public boolean isValidUsernameWhenLoginTypeIsCredentials() {
        return !LoginTypeEnum.CREDENTIALS.equals(loginType) || (username != null && !username.trim().isEmpty());
    }

    @AssertTrue(message = "password is required when loginType is 'CREDENTIALS'")
    public boolean isValidPasswordWhenLoginTypeIsCredentials() {
        return !LoginTypeEnum.CREDENTIALS.equals(loginType) || (password != null && !password.trim().isEmpty());
    }

    @AssertTrue(message = "token is required when loginType is 'REFRESH_TOKEN'")
    public boolean isValidTokenWhenLoginTypeIsRefreshToken() {
        return !LoginTypeEnum.REFRESH_TOKEN.equals(loginType) || (token != null && !token.trim().isEmpty());
    }
}
