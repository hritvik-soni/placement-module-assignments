package com.hritvik.userdetails.model.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInput {


        private String userName;
        private String userEmail;
        private String userPassword;
        private String  userAddress;
        private String  userPhoneNo;
        private String  userDesc;

}
