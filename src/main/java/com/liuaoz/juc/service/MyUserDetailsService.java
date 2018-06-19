package com.liuaoz.juc.service;

import com.liuaoz.juc.model.user.UserEntity;
import com.liuaoz.juc.service.user.IUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by matrix_stone on 2018/6/19.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encode = passwordEncoder.encode("");

        List<UserEntity> list = iUserService.listAll();

        User user = null;
        for (UserEntity userEntity : list) {
            if (userEntity.getUserName().equals(username)) {
                //
                user = new User(userEntity.getUserName(), userEntity.getPassword(), null);
                return user;
            }
        }

        return user;
    }
}
