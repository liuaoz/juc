package com.liuaoz.juc.controller.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description : TODO
 * @Author : matrix
 * @Date : created in 2018/6/9 22:34
 */
@Slf4j
public class SynchronizedDemo {

    /**
     * 修改一个代码块
     */
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1--->{}", i);
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2--->{}", i);
        }
    }

    public static void main(String[] args) {

    }
}
