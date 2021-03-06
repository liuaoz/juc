package com.liuaoz.juc.controller.concurrency.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CopyOnWriteArrayList
 *
 * Created by matrix_stone on 2018/6/12.
 */
@Slf4j
public class CopyOnWriteArrayListDemo1 {

    //请求客户数
    public static final int clientTotal = 5000;
    //并发线程数
    public static final int threadTotal = 200;

    public static int count = 0;

    private static CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    updateC1(count);
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
        log.info("list-size:{}", copyOnWriteArrayList.size());
    }

    private static void updateC1(int count) {
        copyOnWriteArrayList.add(count);
    }
}
