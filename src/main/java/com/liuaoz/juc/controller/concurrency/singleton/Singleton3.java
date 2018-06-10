package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 懒汉模式
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@ThreadSafe
@Slf4j
public class Singleton3 {

    private Singleton3(){}

    private static Singleton3 instance = null;

    public synchronized static Singleton3 getInstance() {
        if(instance == null){
            return new Singleton3();
        }
        return instance;
    }
}
