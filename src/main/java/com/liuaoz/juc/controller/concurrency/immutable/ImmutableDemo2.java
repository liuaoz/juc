package com.liuaoz.juc.controller.concurrency.immutable;

import com.liuaoz.juc.core.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : Collections unmodifiableXXX
 * @Author : matrix
 * @Date : created in 2018/6/10 21:30
 */
@Slf4j
@ThreadSafe
public class ImmutableDemo2 {


    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        log.info(map.toString());

        map.put(6,7);

        log.info(map.toString());
    }
}
