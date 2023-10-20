package com.hritvik.userdetailswithsecurity.controller;

import com.hritvik.userdetailswithsecurity.model.UserInfo;
import com.hritvik.userdetailswithsecurity.model.dto.PasswordDto;
import com.hritvik.userdetailswithsecurity.repository.UserInfoRepository;
import com.hritvik.userdetailswithsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    UserInfoRepository repository;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("email") String email){

        UserInfo user = repository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        String token = UUID.randomUUID().toString();
        service.createPasswordResetTokenForUser(user, token);
        return token;
    }

    @PostMapping("/savePassword")
    public String savePassword(@RequestBody PasswordDto passwordDto) {

        String result = service.validatePasswordResetToken(passwordDto.getToken());

        if(result != null) {
            return "Invalid token or token Expired";
        }
         return service.changePassword(passwordDto);


    }
}
