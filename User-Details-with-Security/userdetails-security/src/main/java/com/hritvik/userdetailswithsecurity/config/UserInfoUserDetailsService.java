package com.hritvik.userdetailswithsecurity.config;


import com.hritvik.userdetailswithsecurity.model.UserInfo;
import com.hritvik.userdetailswithsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = repository.findByEmail(username);
        Integer id = user.getId();
        Optional<UserInfo> userInfo = repository.findById(id);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
