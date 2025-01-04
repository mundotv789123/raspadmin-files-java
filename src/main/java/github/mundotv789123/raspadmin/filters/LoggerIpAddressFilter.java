package github.mundotv789123.raspadmin.filters;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class LoggerIpAddressFilter implements Filter {

    @Value("${application.trust.ips:''}")
    private String trustIps;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String remoteAddress = httpRequest.getRemoteAddr();
        String ipAddress = remoteAddress;

        String ipAddressHeader = httpRequest.getHeader("X-Forwarded-For");
        if (ipAddressHeader != null) {
            var trustIpsSplited = Arrays.asList(trustIps.split(","));
            if (trustIpsSplited.stream().filter(ip -> isIpInRange(remoteAddress, ip)).count() > 0) {
                ipAddress = ipAddressHeader;
            }
        }

        org.apache.logging.log4j.ThreadContext.put("ipAddress", ipAddress);
        chain.doFilter(request, response);
    }

    private boolean isIpInRange(String ipAddress, String cidr) {
        IpAddressMatcher ipMatcher = new IpAddressMatcher(cidr);
        return ipMatcher.matches(ipAddress);
    }
}
