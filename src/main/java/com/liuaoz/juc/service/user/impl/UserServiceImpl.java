package com.liuaoz.juc.service.user.impl;

import com.liuaoz.juc.model.user.UserEntity;
import com.liuaoz.juc.service.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matrix_stone on 2018/6/19.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserEntity getById(Long id) {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("admin");
        user.setPassword("111111");
        user.setAge(10);
        return user;
    }

    @Override
    public UserEntity getByName(String name) {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName(name);
        user.setPassword("111111");
        user.setAge(10);
        return user;
    }

    @Override
    public List<UserEntity> listAll() {
        return mock();
    }

    private List<UserEntity> mock() {

        List<UserEntity> list = new ArrayList<>();

        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setUserName("admin");
        user1.setPassword("111111");
        user1.setAge(10);
        list.add(user1);

        UserEntity user2 = new UserEntity();
        user2.setId(2L);
        user2.setUserName("test");
        user2.setPassword("111111");
        user2.setAge(20);
        list.add(user2);

        UserEntity user3 = new UserEntity();
        user3.setId(3L);
        user3.setUserName("demo");
        user3.setPassword("111111");
        user3.setAge(30);
        list.add(user3);

        return list;
    }
}
