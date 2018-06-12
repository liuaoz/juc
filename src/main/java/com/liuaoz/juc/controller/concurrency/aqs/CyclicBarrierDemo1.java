package com.liuaoz.juc.controller.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * CyclicBarrier
 * Created by matrix_stone on 2018/6/12.
 */
@Slf4j
public class CyclicBarrierDemo1 {

    private static final int threadTotal = 5;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(threadTotal);

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0;i<10;i++){
            Thread.sleep(1000);
            final int threadNum = i ;
            executorService.execute(()->{
                race(threadNum);
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum){

        try {

            Thread.sleep(1000);
            log.info("{} is ready.",threadNum);
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);

            log.info("{} continue",threadNum);

        } catch (Exception e) {
            log.error("Exception:");
        }
    }
}
