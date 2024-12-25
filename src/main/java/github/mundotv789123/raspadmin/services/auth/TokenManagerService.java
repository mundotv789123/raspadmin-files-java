package github.mundotv789123.raspadmin.services.auth;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import github.mundotv789123.raspadmin.models.UserModel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TokenManagerService {

    @Value("${application.security.jwt.secret}")
    private String secret;

    private static final String DEFAULT_INSSUER = "token";

    private @Getter int tokenExpireMinutes = 1440;

    public String getToken(UserModel user) {
        if (!StringUtils.hasText(secret)) {
            secret = UUID.randomUUID().toString();
            log.warn("JWT secrect is empty, generated key: " + secret);
        }

        var expiresAt = Calendar.getInstance();
        expiresAt.add(Calendar.MINUTE, tokenExpireMinutes);

        return JWT.create()
            .withIssuer(DEFAULT_INSSUER)
            .withSubject(user.getUsername())
            .withExpiresAt(expiresAt.toInstant())
            .sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String tokenSrt) {
        try {
            var token = JWT.require(Algorithm.HMAC256(secret)).withIssuer(DEFAULT_INSSUER).build();
            return token.verify(tokenSrt).getSubject();
        } catch (Exception ex) {
            return null;
        }
    }
}
