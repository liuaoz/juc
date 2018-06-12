package com.liuaoz.juc.controller.concurrency.threadlocal;

/**
 * Created by matrix_stone on 2018/6/11.
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHOlder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHOlder.set(id);
    }

    public static Long getId() {
        return requestHOlder.get();
    }

    public static void remove() {
        requestHOlder.remove();
    }

}
