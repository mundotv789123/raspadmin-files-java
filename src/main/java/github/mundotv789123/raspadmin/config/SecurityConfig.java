package github.mundotv789123.raspadmin.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${application.security.disabled:false}")
    private boolean securityDisabled;

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
        http.exceptionHandling((exceptionHandler) -> exceptionHandler.authenticationEntryPoint((request, response, ex) ->
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())
        ));
        http.formLogin((login) ->
                login.loginProcessingUrl("/api/auth/login")
        );
        http.csrf((csrf) -> csrf.disable());
        return http.build();
    }

}
