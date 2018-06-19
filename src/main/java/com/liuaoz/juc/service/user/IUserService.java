package com.liuaoz.juc.service.user;

import com.liuaoz.juc.model.user.UserEntity;

import java.util.List;

/**
 * Created by matrix_stone on 2018/6/19.
 */
public interface IUserService {

    UserEntity getById(Long id);

    UserEntity getByName(String name);

    List<UserEntity> listAll();
}
