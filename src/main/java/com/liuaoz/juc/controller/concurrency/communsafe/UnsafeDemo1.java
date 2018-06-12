package com.liuaoz.juc.controller.concurrency.communsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matrix_stone on 2018/6/11.
 */
@Slf4j
public class UnsafeDemo1 {

    //请求客户数
    public static final int clientTotal = 5000;
    //并发线程数
    public static final int threadTotal = 200;

    public static int count = 0;

    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            stringBuffer.append("1");
        });

        log.info(String.valueOf(stringBuffer.length()));

    }

}
