package com.hritvik.userdetails.service;


import com.hritvik.userdetails.model.Users;
import com.hritvik.userdetails.model.dto.UserDetailsDeleteInput;
import com.hritvik.userdetails.model.dto.UserInput;
import com.hritvik.userdetails.model.dto.UserUpdateInput;
import com.hritvik.userdetails.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;



    public String createUser(UserInput userInput) {

        String email = userInput.getUserEmail();

        if(userRepo.findByUserEmail(email)!=null){
            return "User Already exist";
        }

        Users user = Users.builder()
                .userName(userInput.getUserName())
                .userEmail(userInput.getUserEmail())
                .userAddress(userInput.getUserAddress())
                .userDesc(userInput.getUserDesc())
                .userPassword(userInput.getUserPassword())
                .userPhoneNo(userInput.getUserPhoneNo())
                .build();

          userRepo.save(user);

        return "User Added Successfully";
    }

    public Optional<Users> getUser(Integer id) {

        return userRepo.findById(id);
    }

    public String updateUser(Integer id, UserUpdateInput userUpdateInput) {

        Optional<Users> user = userRepo.findById(id);

        if(user.isPresent()){
            if(userUpdateInput.getUserDesc()!=null){
                user.get().setUserDesc(userUpdateInput.getUserDesc());
            }
            if(userUpdateInput.getUserAddress()!=null){
                user.get().setUserAddress(userUpdateInput.getUserAddress());
            }
            if(userUpdateInput.getUserPassword()!=null){
                user.get().setUserPassword(userUpdateInput.getUserPassword());
            }
            if(userUpdateInput.getUserPhoneNo()!=null){
                user.get().setUserPhoneNo(userUpdateInput.getUserPhoneNo());
            }

            return "User Details Updated successfully";
        }

        return "Invalid user Id";


    }

    public String removeUser(Integer id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "user removed successfully";
        }
        return "Invalid user Id";
    }

    public String removeUserDetails(Integer id, UserDetailsDeleteInput userDetailsDeleteInput) {
        Optional<Users> user = userRepo.findById(id);

        if(user.isPresent()){
            if(userDetailsDeleteInput.getUserDesc()!=null){
                user.get().setUserDesc(null);
            }
            if(userDetailsDeleteInput.getUserAddress()!=null){
                user.get().setUserAddress(null);
            }
            return "User Details deleted successfully";
        }

        return "Invalid user Id";
    }
}
