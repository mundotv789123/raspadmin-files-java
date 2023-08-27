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

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${application.security.disabled:false}")
    private boolean securityDisabled;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    @Autowired
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        if (securityDisabled) {
            http.authorizeHttpRequests((request) -> request.requestMatchers("/**").permitAll().anyRequest().authenticated());
            return http.build();
        }
        http.authorizeHttpRequests((request) ->
                request.requestMatchers("/*", "/_next/**", "/img/**", "/api/auth/login").permitAll().anyRequest().authenticated()
        );
        http.exceptionHandling((exceptionHandler) ->
                exceptionHandler.authenticationEntryPoint((request, response, ex) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");

                    var responseBody = new HashMap<String, String>();
                    responseBody.put("message", ex.getMessage());

                    ObjectMapper objectMapper = new ObjectMapper();
                    response.getWriter().write(objectMapper.writeValueAsString(responseBody));
                })
        );
        http.formLogin((login) ->
                login.loginProcessingUrl("/api/auth/login").failureHandler((request, response, ex) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");

                    var responseBody = new HashMap<String, String>();
                    responseBody.put("message", ex.getMessage());

                    ObjectMapper objectMapper = new ObjectMapper();
                    response.getWriter().write(objectMapper.writeValueAsString(responseBody));
                }).successHandler((request, response, ex) -> {
                    response.setStatus(HttpServletResponse.SC_OK);
                })
        );
        http.csrf((csrf) -> csrf.disable());
        return http.build();
    }
}
