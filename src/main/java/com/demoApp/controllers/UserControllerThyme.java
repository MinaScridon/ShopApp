package com.demoApp.controllers;

import com.demoApp.entities.User;
import com.demoApp.repository.UserRepo;
import com.demoApp.service.UserService;
import com.demoApp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllerThyme {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/index")
    public String home(){

        return "index";
    }

    @GetMapping("/register")
    public String registrationForm(ModelMap model){

        UserDto dto = new UserDto();
        model.addAttribute("user",dto);

        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@ModelAttribute("user") UserDto userDto, ModelMap map, BindingResult result){

        User userFromDb = userService.findUserByEmail(userDto.getEmail());

//        userRepo.findByEmail(userDto.getEmail())  - findByEmail to be optional

        if (userFromDb != null && userFromDb.getEmail() != null){

            result.rejectValue("email",null,"This email already exists.");

        }
        userService.saveUser(userDto);

        return "redirect:/register?success";
    }

}
