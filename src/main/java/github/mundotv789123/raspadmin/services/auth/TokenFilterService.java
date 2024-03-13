package github.mundotv789123.raspadmin.services.auth;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import github.mundotv789123.raspadmin.models.UserModel;
import github.mundotv789123.raspadmin.repositories.UsersRespository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilterService extends GenericFilterBean {

    private final UsersRespository respository;
    private final TokenManagerService tokenService;

    public TokenFilterService(UsersRespository respository, TokenManagerService tokenService) {
        this.respository = respository;
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = null;

        Cookie[] cookies = request.getCookies();
        if ((cookies != null && cookies.length > 0)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        } else {
            var header = request.getHeader("Authorization");
            if (header != null) {
                token = header.replace("Bearer ", "");
            }
        }

        if (token != null) {
            String subject = this.tokenService.getSubject(token);
            if (subject != null) {
                UserModel user = this.respository.findUserByUsername(subject).get();
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}