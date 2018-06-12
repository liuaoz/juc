package com.liuaoz.juc.controller.concurrency.synccontainer;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * 同步容器不一定是线程安全的：
 * <p>
 * Vector
 * 使用joda-time包
 * Created by matrix_stone on 2018/6/11.
 */
@Slf4j
@NotThreadSafe
public class UnSafeDemo1 {

    private static Vector<Integer> vector = new Vector();

    public static void main(String[] args) {

        while(true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) { //线程1执行到这边时，
                    vector.remove(i);
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {//线程2执行到这边
                    vector.get(i);
                }
            });

            t1.start();
            t2.start();
        }

    }
}
