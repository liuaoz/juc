package com.liuaoz.juc.controller.concurrency.singleton;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 双重同步锁单例模式
 * @Author : matrix
 * @Date : created in 2018/6/10 16:02
 */
@ThreadSafe
@Slf4j
public class Singleton6 {

    //volatile两个使用场景：1.状态标识 2. 双重检测

    private Singleton6() {
    }

    private volatile static Singleton6 instance = null; //使用volatile限制指令重排，解决安全问题

    //不安全的原因，是由于对象创建需要一个过程
    // 1.memory = allocate() 分配对象的内存空间
    // 2.ctorInstance() 初始化对象
    // 3.instance = memory 设置instance指向刚分配的内存

    // JVM和cpu和优化，发生了指令重排，以上顺序发生变化
    // 1.memory = allocate() 分配对象的内存空间
    // 3.instance = memory 设置instance指向刚分配的内存
    // 2.ctorInstance() 初始化对象



    public static Singleton6 getInstance() {
        if (instance == null) { //双重检测 //线程B，判断对象不为空，直接返回未初始化的对象
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6(); //线程A - 3
                }
            }
        }
        return instance;
    }
}
