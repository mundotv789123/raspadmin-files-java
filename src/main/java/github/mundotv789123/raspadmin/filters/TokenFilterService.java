package github.mundotv789123.raspadmin.filters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import github.mundotv789123.raspadmin.models.entities.UserEntity;
import github.mundotv789123.raspadmin.services.auth.TokenManagerService;
import github.mundotv789123.raspadmin.services.auth.UsersService;
import jakarta.annotation.Nullable;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenFilterService extends GenericFilterBean {

    private final UsersService usersService;
    private final TokenManagerService tokenService;
  
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = getTokenByCookie(request);
        if (token == null)
            token = getTokenByHeader(request);

        if (token != null) {
            validateToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private void validateToken(String token) {
        String subject = this.tokenService.getSubject(token);
        if (subject != null) {
            UserEntity user = this.usersService.findUserByUsername(subject).get();
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private @Nullable String getTokenByCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ((cookies == null || cookies.length == 0)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    private @Nullable String getTokenByHeader(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if (header != null) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
}