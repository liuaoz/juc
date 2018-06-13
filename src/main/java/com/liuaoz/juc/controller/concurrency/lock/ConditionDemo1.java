package com.liuaoz.juc.controller.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ConditionDemo1 {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition = reentrantLock.newCondition();

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        exe(executorService);

        exe2(executorService);

        countDownLatch.await();

        executorService.shutdown();

    }

    private static void exe(ExecutorService executorService) {
        executorService.execute(() -> {

            try {
                reentrantLock.lock(); // 1.锁定
                log.info("wait signal");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal");
            reentrantLock.unlock();

            countDownLatch.countDown();
        });
    }

    private static void exe2(ExecutorService executorService) {
        executorService.execute(() -> {

            try {
                reentrantLock.lock(); // 2
                log.info("get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal ~");
            reentrantLock.unlock();

            countDownLatch.countDown();
        });
    }

}
