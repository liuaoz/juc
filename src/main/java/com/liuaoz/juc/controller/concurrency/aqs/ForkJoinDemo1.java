package com.liuaoz.juc.controller.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ForkJoinDemo1 extends RecursiveTask<Integer> {

    public static final int threshold = 2;
    private int start;
    private int end;

    public ForkJoinDemo1(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= threshold;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个字任务计算
            int middle = (start + end) / 2;
            ForkJoinDemo1 leftTask = new ForkJoinDemo1(start, middle);
            ForkJoinDemo1 rightTask = new ForkJoinDemo1(middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;

        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinDemo1 forkJoinDemo1 = new ForkJoinDemo1(1, 100);

        Future<Integer> future = forkJoinPool.submit(forkJoinDemo1);

        try {
            Integer result = future.get();
            log.info("result:{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
