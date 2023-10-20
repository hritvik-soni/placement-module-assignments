package com.hritvik.userdetailswithsecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDto {
    private String token;
    private String password;


}
