package github.mundotv789123.raspadmin.services.auth;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import github.mundotv789123.raspadmin.models.entities.UserEntity;
import github.mundotv789123.raspadmin.models.entities.UserSessionEntity;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TokenManagerService {

    @Value("${application.security.jwt.secret}")
    private String secret;

    private static final String DEFAULT_INSSUER = "token";

    private @Getter int tokenExpireMinutes = 10;

    public String getUserToken(UserEntity user) {
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
            .withClaim("roles", user.getAuthorities().stream().map(role -> role.getAuthority()).toList())
            .sign(Algorithm.HMAC256(secret));
    }

    public String getSessionToken(UserSessionEntity session) {
        if (!StringUtils.hasText(secret)) {
            secret = UUID.randomUUID().toString();
            log.warn("JWT secrect is empty, generated key: " + secret);
        }

        return JWT.create()
            .withIssuer(DEFAULT_INSSUER)
            .withSubject(session.getRefreshToken())
            .withExpiresAt(session.getExpireAt().toInstant())
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
