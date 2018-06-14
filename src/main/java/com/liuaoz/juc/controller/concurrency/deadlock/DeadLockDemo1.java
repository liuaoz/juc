package com.liuaoz.juc.controller.concurrency.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 发生死锁，线程先锁定一个对象，然后再释放前锁定另外一个对象
 * Created by matrix_stone on 2018/6/14.
 */
@Slf4j
public class DeadLockDemo1 {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                synchronized (object1) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object2) {
                        log.info("1thread num 2.");
                    }
                    log.info("1thread num 1.");
                }
            });
        }
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                synchronized (object2) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object1) {
                        log.info("2thread num 2.");
                    }
                    log.info("2thread num 1.");
                }
            });
        }
    }
}
