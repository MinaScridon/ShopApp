package com.demoApp.service;


import com.demoApp.entities.User;
import com.demoApp.dto.UserDto;

public interface UserService {

    User findUserByName(String name);

    User findUserByEmail(String email);

    void saveUser(UserDto dto);
}
