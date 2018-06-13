package com.liuaoz.juc.controller.concurrency.aqs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class FutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Data> future = executorService.submit(()->{
            Data data = new Data();
            data.setId(1);
            for(long i=0;i<10000000000L;i++){
                log.info("xxx");
            }
            return data;
        });
        Thread.sleep(100);
        future.cancel(true);
        log.info("--->{}","x");

    }
}

class MyCallable implements Callable<Data>{

    @Override
    public Data call() throws Exception {
        return null;
    }
}

@Setter
@Getter
@NoArgsConstructor
class Data{
    private Integer id;
}
