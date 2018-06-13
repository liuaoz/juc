package com.liuaoz.juc.controller.concurrency.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ThreadPoolDemo3 {



    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        //        executorService.schedule(() -> log.info("doing..."), 5, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            log.info("doing...");
        }, 1, 3, TimeUnit.SECONDS);

        //        executorService.shutdown();

        Timer timer = new Timer("test");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("xxxx");
            }
        };

        timer.scheduleAtFixedRate(timerTask, 1L, 3L);
    }
}
