package com.liuaoz.juc.controller.concurrency.lock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 悲观读取
 * 读多写少，造成线程饥饿
 * Created by matrix_stone on 2018/6/13.
 */
@Slf4j
public class ReentrantReadWriteLockDemo1 {

    private static Map<String, Data> map = new TreeMap<>();

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = reentrantReadWriteLock.readLock();

    private static Lock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) throws InterruptedException {

    }

    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(Map<String, Data> map) {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }

    }

    public void put(String key, Data data) {
        writeLock.lock();
        try {
            map.put(key, data);
        } finally {
            writeLock.unlock();
        }
    }
}


@Setter
@Getter
@NoArgsConstructor
class Data {

    private Integer id;

    public Data(Integer id) {
        this.id = id;
    }
}
