package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.Recommend;
import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 枚举 最安全
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@ThreadSafe
@Slf4j
@Recommend
public class Singleton8 {

    private Singleton8() {
    }

    private static Singleton8 instance = null;

    public static Singleton8 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private Singleton8 singleton8;

        //jvm保证这方法绝对只调用一次
        Singleton() {
            singleton8 = new Singleton8();
        }

        public Singleton8 getInstance() {
            return singleton8;
        }
    }

}
