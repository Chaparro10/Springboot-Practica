package com.platzi.platzi_pizzeria.web.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter  extends OncePerRequestFilter {
    private JwtUtil jwtUtil;
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //validar que sea un header authorization valido
        String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader == null || authHeader.isEmpty()){
            filterChain.doFilter(request,response);
            return;
        }
        //validar el JWT sea valido
        String jwt = authHeader.split("")[1].trim();

        if(!jwtUtil.isValid(jwt)){
            filterChain.doFilter(request,response);
            return;
        }
        //Cargar el usuario del UserDetailService
        String username = this.jwtUtil.getUsername(jwt);
        User user = (User) this.userDetailsService.loadUserByUsername(username);
        //Cargar al usuario en el contexto de seguridad

        UsernamePasswordAuthenticationToken  authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(),user.getPassword(),user.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);

    }
}
