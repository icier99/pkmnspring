package ici.er.pkmn.security.filters;

import com.auth0.jwt.interfaces.DecodedJWT;
import ici.er.pkmn.security.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");
        if (Objects.isNull(jwt) || !jwt.startsWith("Bearer")) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("jwt")) {
                    jwt = new String(Base64.getDecoder().decode(cookie.getValue()));
                }
            }
            if (Objects.isNull(jwt)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        if (jwt.startsWith("Bearer")) {
            jwt = jwt.substring(7);
        }
        jwtService.verify(jwt);

        DecodedJWT decodedJWT = jwtService.verify(jwt);

        if (Objects.isNull(decodedJWT)) {
            filterChain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        decodedJWT.getSubject(),
                        null,
                        decodedJWT.getClaim("authorities").asList(SimpleGrantedAuthority.class)
                )
        );

        filterChain.doFilter(request, response);
    }
}
