package github.mundotv789123.raspadmin.services.auth;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import github.mundotv789123.raspadmin.models.UserModel;

@Service
public class TokenManagerService {

    @Value("${application.security.jwt.secret}")
    private String secret;

    private String DEFAULT_INSSUER = "token";

    public String getToken(UserModel user) {
        if (secret == null || secret.isEmpty())
            throw new NullPointerException("JWT Secret key can not be null");
        var jwt = JWT.create()
            .withIssuer(DEFAULT_INSSUER)
            .withSubject(user.getUsername())
            .withExpiresAt(LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-03:00")))
            .sign(Algorithm.HMAC256(secret));
        return jwt;
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
