package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 饿汉模式
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@ThreadSafe
@Slf4j
public class Singleton7 {

    private Singleton7(){}

    private static Singleton7 instance = null;

    static {
        instance = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return instance;
    }
}
