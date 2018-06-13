package com.liuaoz.juc.controller.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对象层面的锁定
 * 吞吐量高
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ReentrantLockDemo1 {

    private static final int clientTotal = 5000;

    private static final int threadTotal = 200;

    private static int count = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        Semaphore semaphore = new Semaphore(threadTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int num = i;
            executorService.execute(() -> {

                try {
                    semaphore.acquire();
                    doSomething(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }

            });
        }

        countDownLatch.await();

        log.info("====== main finished. ========");

    }

    private static void doSomething(int num) {
        reentrantLock.lock();
        try {
            //            Thread.sleep(1000);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        log.info("{} - do... count={}", num, count);
    }
}
