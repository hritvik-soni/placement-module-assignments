package com.hritvik.userdetailswithsecurity.repository;

import com.hritvik.userdetailswithsecurity.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken,Long> {
    PasswordResetToken findByToken(String token);


}
