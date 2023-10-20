package com.hritvik.userdetails.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateInput {

    private String userPassword;
    private String  userAddress;
    private String  userPhoneNo;
    private String  userDesc;
}
