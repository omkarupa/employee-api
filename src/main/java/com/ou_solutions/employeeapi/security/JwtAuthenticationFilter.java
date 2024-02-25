package com.ou_solutions.employeeapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final EmployeeUserDetailsService employeeUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        String token = jwtTokenUtil.getToken(request);

        if(token != null && jwtTokenUtil.validateToken(token))
        {
            String username = jwtTokenUtil.extractUserName(token);

            UserDetails userDetails =  employeeUserDetailsService.loadUserByUsername(username);

            if(userDetails != null)
            {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);



            }

        }

        filterChain.doFilter(request,response);

    }
}
