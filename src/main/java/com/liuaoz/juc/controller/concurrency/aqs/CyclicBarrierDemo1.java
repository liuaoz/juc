package com.liuaoz.juc.controller.concurrency.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by matrix_stone on 2018/6/12.
 */
public class CyclicBarrierDemo1 {

    private static final int threadTotal = 10;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {

        });

    }
}
