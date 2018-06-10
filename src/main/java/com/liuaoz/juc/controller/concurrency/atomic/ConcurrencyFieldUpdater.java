package com.liuaoz.juc.controller.concurrency.atomic;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by matrix_stone on 2018/6/9.
 */
@Slf4j
@ThreadSafe
public class ConcurrencyFieldUpdater {

    private static AtomicIntegerFieldUpdater<ConcurrencyFieldUpdater> updater = AtomicIntegerFieldUpdater.newUpdater(ConcurrencyFieldUpdater.class, "count");


    @Getter
    public volatile int count = 100;

    private static ConcurrencyFieldUpdater concurrencyFieldUpdater = new ConcurrencyFieldUpdater();


    public static void main(String[] args) {

        if (updater.compareAndSet(concurrencyFieldUpdater, 100, 120)) {
            log.info("success, count:{}", concurrencyFieldUpdater.getCount());
        }

        if (updater.compareAndSet(concurrencyFieldUpdater, 100, 150)) {
            log.info("success, count:{}", concurrencyFieldUpdater.getCount());
        } else {
            log.info("failed, count:{}", concurrencyFieldUpdater.getCount());
        }
    }

}
