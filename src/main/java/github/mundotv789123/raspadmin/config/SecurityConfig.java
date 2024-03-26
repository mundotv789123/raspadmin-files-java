package github.mundotv789123.raspadmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import github.mundotv789123.raspadmin.services.auth.TokenFilterService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${application.security.enable:false}")
    private boolean enabled;

    private final TokenFilterService tokenFilter;

    public SecurityConfig(TokenFilterService tokenFilter) {
        this.tokenFilter = tokenFilter;
    }

    @PostConstruct
    public void enableAuthenticationContextOnAsyncThreads() {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        if (!enabled) {
            http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
            return http.build();
        }

        http.headers(headers -> headers.disable());

        http.authorizeHttpRequests(request ->
            request.requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
        );

        http.addFilterBefore(this.tokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling(exceptionHandler ->
            exceptionHandler.authenticationEntryPoint((request, response, ex) ->
                sendMessageResponse(response, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())
            )
        );

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
