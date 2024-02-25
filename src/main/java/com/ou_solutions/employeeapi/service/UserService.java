package com.ou_solutions.employeeapi.service;

import com.ou_solutions.employeeapi.dto.EmployeeRequest;
import com.ou_solutions.employeeapi.entity.UserDO;
import com.ou_solutions.employeeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

        return UserDO.build(0L,username,password,mobile,null);
    }


}
