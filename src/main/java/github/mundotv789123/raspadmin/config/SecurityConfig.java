package github.mundotv789123.raspadmin.config;

import github.mundotv789123.raspadmin.handlers.CustomAuthenticationEntryPoint;
import github.mundotv789123.raspadmin.services.auth.TokenFilterService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

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

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${application.security.enable:false}")
    private boolean enabled;

    private final TokenFilterService tokenFilter;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @PostConstruct
    public void enableAuthenticationContextOnAsyncThreads() {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
   
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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
            exceptionHandler.authenticationEntryPoint(customAuthenticationEntryPoint)
        );

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
