package com.liuaoz.juc.controller.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description : synchronized
 * @Author : matrix
 * @Date : created in 2018/6/9 22:34
 */
@Slf4j
public class SynchronizedDemo {

    /**
     * 修改一个代码块
     */
    public void test1(int thread) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("thread:{} ===> test1--->{}",thread, i);
            }
        }
    }

    public synchronized void test2(int thread) {
        for (int i = 0; i < 10; i++) {
            log.info("thread:{} ===> test2--->{}",thread, i);
        }
    }

    public static void main(String[] args) {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            demo1.test1(1);
        });

        executorService.execute(() -> {
            demo2.test1(2);
        });


    }
}
