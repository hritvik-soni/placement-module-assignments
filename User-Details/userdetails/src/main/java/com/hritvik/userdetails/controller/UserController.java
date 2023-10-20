package com.hritvik.userdetails.controller;

import com.hritvik.userdetails.model.Users;
import com.hritvik.userdetails.model.dto.UserDetailsDeleteInput;
import com.hritvik.userdetails.model.dto.UserInput;
import com.hritvik.userdetails.model.dto.UserUpdateInput;
import com.hritvik.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/new")
    public String createUser(@RequestBody UserInput userInput){

        return userService.createUser(userInput);

    }

    @GetMapping("/search")
    public Optional<Users> getUser(@RequestParam("id") Integer id){

        return userService.getUser(id);

    }

    @PutMapping("/update")
    public String updateUser(@RequestParam("id") Integer id,UserUpdateInput userUpdateInput ){

        return userService.updateUser(id,userUpdateInput);

    }

    @DeleteMapping("/remove")
    public String removeUser(@RequestParam("id") Integer id){

        return userService.removeUser(id);

    }

    @DeleteMapping("/remove/details")
    public String removeUserDetails(@RequestParam("id") Integer id, @RequestBody UserDetailsDeleteInput userDetailsDeleteInput){

        return userService.removeUserDetails(id,userDetailsDeleteInput);

    }







}
