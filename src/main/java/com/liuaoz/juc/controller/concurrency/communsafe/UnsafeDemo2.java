package com.liuaoz.juc.controller.concurrency.communsafe;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SimpleDateFormat sdf 不是线程安全对象
 * Created by matrix_stone on 2018/6/11.
 */
@Slf4j
@NotThreadSafe
public class UnsafeDemo2 {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    //请求客户数
    public static final int clientTotal = 5000;
    //并发线程数
    public static final int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
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

    }

    private static void update() {
        try {
            sdf.parse("20180612");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
