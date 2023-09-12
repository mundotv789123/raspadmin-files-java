package github.mundotv789123.raspadmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${application.security.disabled:false}")
    private boolean securityDisabled;

    @Bean
    @Autowired
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        if (securityDisabled) {
            http.authorizeHttpRequests(request -> request.requestMatchers("/**").permitAll().anyRequest().authenticated());
            return http.build();
        }
        http.authorizeHttpRequests(request ->
            request.requestMatchers("/*", "/_next/**", "/img/**", "/api/auth/login").permitAll().anyRequest().authenticated()
        );
        http.exceptionHandling(exceptionHandler ->
            exceptionHandler.authenticationEntryPoint((request, response, ex) ->
                sendMessageResponse(response, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())
            )
        );
        http.formLogin(login ->
            login.loginProcessingUrl("/api/auth/login").failureHandler((request, response, ex) ->
                sendMessageResponse(response, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())
            ).successHandler((request, response, ex) -> response.setStatus(HttpServletResponse.SC_OK))
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    public void sendMessageResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");

        var responseBody = new HashMap<String, String>();
        responseBody.put("message", message);

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(responseBody));
    }
}
