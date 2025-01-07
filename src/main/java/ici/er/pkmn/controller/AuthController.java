package ici.er.pkmn.controller;

import ici.er.pkmn.security.jwt.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final JwtService jwtService;

    @PostMapping("/success")
    public RedirectView success(@AuthenticationPrincipal UserDetails userDetails, HttpServletResponse servletResponse) {
        String jwt = jwtService.createToken(userDetails.getUsername(), userDetails.getAuthorities().iterator().next());

        servletResponse.addCookie(
                new Cookie("jwt", Base64.getEncoder().encodeToString(jwt.getBytes(StandardCharsets.UTF_8)))
        );

        return new RedirectView("/api/v1/students/all");
    }
}
