package com.hritvik.userdetails.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsDeleteInput {

    private String  userAddress;
    private String  userDesc;
}
