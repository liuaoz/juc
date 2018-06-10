package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 安全发布对象-单例
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@NotThreadSafe
@Slf4j
public class Singleton1 {

    private Singleton1(){}

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null){
            return new Singleton1();
        }
        return instance;
    }
}
