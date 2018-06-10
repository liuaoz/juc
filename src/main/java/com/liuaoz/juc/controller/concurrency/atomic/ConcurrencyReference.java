package com.liuaoz.juc.controller.concurrency.atomic;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by matrix_stone on 2018/6/9.
 */
@Slf4j
@ThreadSafe
public class ConcurrencyReference {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count:{}",count.get());//4
    }

}
