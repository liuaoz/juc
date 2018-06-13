package com.liuaoz.juc.controller.concurrency.lock;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
@ThreadSafe
public class StampedLockDemo2 {

    private static StampedLock stampedLock = new StampedLock();

    private static final int clientTotal = 1000;

    private static final int threadTotal = 100;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int num = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    doSome(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });

        }

        countDownLatch.await();

        log.info("===== count:{}", count);

        executorService.shutdown();
    }

    private static void doSome(int num) {
        long stamp = stampedLock.writeLock();
        count++;
        stampedLock.unlock(stamp);
        log.info("do some: {}", count);
    }


}
