package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 双重同步锁单例模式
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@NotThreadSafe
@Slf4j
public class Singleton5 {

    private Singleton5() {
    }

    private static Singleton5 instance = null;

    //不安全的原因，是由于对象创建需要一个过程
    // 1.memory = allocate() 分配对象的内存空间
    // 2.ctorInstance() 初始化对象
    // 3.instance = memory 设置instance指向刚分配的内存

    // JVM和cpu和优化，发生了指令重排，以上顺序发生变化
    // 1.memory = allocate() 分配对象的内存空间
    // 3.instance = memory 设置instance指向刚分配的内存
    // 2.ctorInstance() 初始化对象



    public static Singleton5 getInstance() {
        if (instance == null) { //双重检测 //线程B，判断对象不为空，直接返回未初始化的对象
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5(); //线程A - 3
                }
            }
        }
        return instance;
    }
}
