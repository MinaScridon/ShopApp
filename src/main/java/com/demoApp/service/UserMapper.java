package com.demoApp.service;

import com.demoApp.entities.User;
import com.demoApp.dto.UserDto;
import com.demoApp.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public UserDto convertToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    @Override
    public User convertToEntity(UserDto dto) {
        return null;
    }
}
