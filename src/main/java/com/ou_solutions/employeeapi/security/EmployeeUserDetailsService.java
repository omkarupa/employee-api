package com.ou_solutions.employeeapi.security;

import com.ou_solutions.employeeapi.entity.UserDO;
import com.ou_solutions.employeeapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class EmployeeUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mapUserDOToUserDetails(username);
    }
public User mapUserDOToUserDetails(String username) throws UsernameNotFoundException
    {
        UserDO userDO = userService.findUserByUsername(username);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userDO.getRoles()));

        return new User(userDO.getUsername(),userDO.getPassword(),authorities);
    }
}
