package com.demoApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserDto {

    private long id;

    @NotEmpty
    @NotBlank(message = "Name is mandatory.")
    private String name;

    private String lastName;

    @NotEmpty
    @NotBlank(message = "Email is mandatory.")
    @Email
    private String email;

    @NotEmpty
    @NotBlank(message = "Password is mandatory.")
    private String password;
}
