package com.liuaoz.juc.controller.concurrency.synccontainer;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Vector
 * 使用joda-time包
 * Created by matrix_stone on 2018/6/11.
 */
@Slf4j
@ThreadSafe
public class SafeDemo2 {

    //请求客户数
    public static final int clientTotal = 5000;
    //并发线程数
    public static final int threadTotal = 200;

    public static int count = 0;

    private static Stack<Integer> vector = new Stack();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    updateS2(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
        log.info("list-size:{}",vector.size());
    }

    private static void updateS2(int count) {
        vector.add(count);
    }
}
