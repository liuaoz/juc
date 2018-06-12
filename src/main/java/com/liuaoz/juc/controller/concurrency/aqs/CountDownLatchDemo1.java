package com.liuaoz.juc.controller.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by matrix_stone on 2018/6/12.
 */
@Slf4j
public class CountDownLatchDemo1 {

    private final static int threadTotal = 200;

    private static CountDownLatch countDownLatch = new CountDownLatch(threadTotal);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadTotal; i++) {
            final int num = i;
            executorService.execute(() -> {
                try {
                    doSomething(num);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();

        log.info("==========finished=========");

        executorService.shutdown(); //使用完毕，关闭线程池
    }

    private static void doSomething(int num) {
        log.info("now count is:{}", num);
    }
}
