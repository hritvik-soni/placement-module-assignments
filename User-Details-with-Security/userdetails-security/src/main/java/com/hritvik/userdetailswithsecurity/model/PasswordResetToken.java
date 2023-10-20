package com.hritvik.userdetailswithsecurity.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = UserInfo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userId")
    private UserInfo user;

    private Date expiryDate;

    public PasswordResetToken(UserInfo user, String token) {

    }
}
