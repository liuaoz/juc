package com.liuaoz.juc.controller.concurrency.publish;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Description : 安全发布对象
 * @Author : matrix
 * @Date : created in 2018/6/10 15:42
 */
@NotThreadSafe
@Slf4j
public class UnsafePublish {

    private String[] states = {"a","b"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {

        UnsafePublish unsafePublish = new UnsafePublish();

        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";

        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
