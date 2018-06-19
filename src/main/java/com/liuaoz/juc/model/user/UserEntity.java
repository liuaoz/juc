package com.liuaoz.juc.model.user;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by matrix_stone on 2018/6/19.
 */
@Setter
@Getter
public class UserEntity {

    private Long id;

    private String userName;

    private String password;

    private Integer age;

}
