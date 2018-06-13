package com.liuaoz.juc.controller.concurrency.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ThreadPoolDemo1 {



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            final int num = i;
            executorService.execute(() -> {
                log.info("now is:{}", num);
            });
        }

        executorService.shutdown();

    }
}
