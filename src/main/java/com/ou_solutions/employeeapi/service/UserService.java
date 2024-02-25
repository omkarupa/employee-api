package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.dto.LoginRequest;
import com.ou_solutions.employeeapi.entity.UserDO;
import com.ou_solutions.employeeapi.repository.UserRepository;
import com.ou_solutions.employeeapi.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;



    public UserDO saveUser(String userName,String password,String mobile)
    {
        return null;
    }

    public UserDO getUserById(Long id)
    {
        return userRepo.findById(id).orElse(new UserDO());
    }

    public List<UserDO> getAllUsers()
    {
        return userRepo.findAll();
    }

    public UserDO mapFromUserRequest(EmployeeRequest request)
    {
        String username = request.getEmailId();
        String password = request.getPassword();
        String mobile = request.getMobile();

        return UserDO.build(0L,username,password,mobile,"USER",null);
    }

    public UserDO findUserByUsername(String username) throws UsernameNotFoundException
    {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Registered"));
    }



}
