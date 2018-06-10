package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 安全发布对象-单例
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@ThreadSafe
@Slf4j
public class Singleton4 {

    private Singleton4(){}

    private static Singleton4 instance = null;

    public synchronized static Singleton4 getInstance() {
        if(instance == null){
            return new Singleton4();
        }
        return instance;
    }
}
