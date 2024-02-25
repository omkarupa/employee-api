package com.ou_solutions.employeeapi.controller;

import com.ou_solutions.employeeapi.dto.LoginRequest;
import com.ou_solutions.employeeapi.entity.UserDO;
import com.ou_solutions.employeeapi.security.JwtTokenUtil;
import com.ou_solutions.employeeapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginRequest request)
    {

        return authenticateUser(request);
    }

    public String authenticateUser(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDO userDO = userService.findUserByUsername(authentication.getName());

        return jwtTokenUtil.generateToken(userDO.getUsername());
    }

}
