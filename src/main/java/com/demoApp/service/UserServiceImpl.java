package com.demoApp.service;

import com.demoApp.entities.Role;
import com.demoApp.entities.User;
import com.demoApp.repository.RoleRepo;
import com.demoApp.repository.UserRepo;
import com.demoApp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

//    public PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public User findUserByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
//        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Role role = roleRepo.findByRole("ADMIN");

        if (role == null){
            role = createRole();
        }

        user.setRoles(Arrays.asList(role));

        userRepo.save(user);
    }

    private Role createRole(){
        Role role = new Role();
        role.setRole("ADMIN");

//        roleRepo.findById(role.getId()).orElseThrow(()->new ResourceNotFoundException("the role with id " + role.getId() + " not found."));

        return roleRepo.save(role);
    }
}
