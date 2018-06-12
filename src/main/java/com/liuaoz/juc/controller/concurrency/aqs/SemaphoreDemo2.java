package com.liuaoz.juc.controller.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore
 * Created by matrix_stone on 2018/6/12.
 */
@Slf4j
public class SemaphoreDemo2 {

    private static final int clientTotal = 50;

    private static final int threadTotal = 5;

    private static Semaphore semaphore = new Semaphore(threadTotal);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < clientTotal; i++) {
            final int num = i;
            executorService.execute(() -> {
                try {
                    if(semaphore.tryAcquire()){ //尝试获取一个许可
                        doSomething2(num);
                        semaphore.release();
                    }else{
                        log.info("can't acquire .");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("============= main finished ==========");
        executorService.shutdown();
    }

    public static void doSomething2(int num) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Now num is : {}", num);
    }
}
