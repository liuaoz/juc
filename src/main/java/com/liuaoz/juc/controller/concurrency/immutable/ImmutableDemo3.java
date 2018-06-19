package com.liuaoz.juc.controller.concurrency.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : guava实现不可变对象
 * @Author : matrix
 * @Date : created in 2018/6/10 21:30
 */
@Slf4j
@ThreadSafe
public class ImmutableDemo3 {

    private static ImmutableList<Integer> immutableList = ImmutableList.of(1, 2);

    private static ImmutableSet<Integer> immutableSet = ImmutableSet.copyOf(immutableList);

    private static ImmutableMap<Integer, Integer> immutableMap = ImmutableMap.of(1, 11, 2, 22);

    public static void main(String[] args) {
        log.info(String.valueOf(immutableMap.get(1)));
        //        immutableMap.put(3,33);
        //        immutableSet.add(3);
        //        immutableList.add(3);
    }

}
