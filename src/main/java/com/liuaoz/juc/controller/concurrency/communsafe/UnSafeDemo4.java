package com.liuaoz.juc.controller.concurrency.communsafe;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * HashSet
 * 使用joda-time包
 * Created by matrix_stone on 2018/6/11.
 */
@Slf4j
@NotThreadSafe
public class UnSafeDemo4 {

    private static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");

    //请求客户数
    public static final int clientTotal = 5000;
    //并发线程数
    public static final int threadTotal = 200;

    public static int count = 0;

    private static Set<Integer> set = new HashSet();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update4(count);
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
        log.info("list-size:{}",set.size());
    }

    private static void update4(int count) {
        // dtf.parseDateTime("20180612");
        Date date = DateTime.parse("20180612", dtf).toDate();
        log.info("{}-->{}",count,date.toString());
        set.add(count);
    }
}
