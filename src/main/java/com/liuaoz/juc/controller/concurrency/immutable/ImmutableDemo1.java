package com.liuaoz.juc.controller.concurrency.immutable;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : TODO
 * @Author : matrix
 * @Date : created in 2018/6/10 21:30
 */
@Slf4j
@NotThreadSafe
public class ImmutableDemo1 {

    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        log.info(map.toString());

        map.put(6,7);

        log.info(map.toString());
    }
}
