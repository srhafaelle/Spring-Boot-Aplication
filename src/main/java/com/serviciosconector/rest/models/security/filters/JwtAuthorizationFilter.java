package com.serviciosconector.rest.models.security.filters;

import com.serviciosconector.rest.models.security.jwp.JwtUtils;
import com.serviciosconector.rest.services.implems.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader( "Authorization");
        if(tokenHeader !=null && tokenHeader.startsWith("Bearer")){
            String token = tokenHeader.substring(7, tokenHeader.length());// se puede dejar el siete solo pero dejo asi
            if(jwtUtils.isTokenValid(token)){
                String username = jwtUtils.getUsernameFromTokem(token);//recuperamos token
                UserDetails userDetails = userDetailsService.loadUserByUsername(username); //recuperamos usuario de la implementacion

                // autenticarse ahora ya con todo
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        filterChain.doFilter(request, response);
    }
}
