package com.liuaoz.juc.controller.concurrency.publish;

import com.liuaoz.juc.core.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 对象溢出(对象未构建完成就发布)
 * @Author : matrix
 * @Date : created in 2018/6/10 15:48
 */
@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanBeEscape = 3;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        Escape escape = new Escape();

    }
}
