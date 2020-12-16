package com.whpu.reentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: xuzhi
 * @date: 2020/12/11 10:13
 * 读写锁演示
 */
public class ReentrantReadWriteLockDemo {
    static Map<String,Object> cacheMap=new HashMap<>();

    static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
    static Lock readLock=reentrantReadWriteLock.readLock();
    static Lock writeLock=reentrantReadWriteLock.writeLock();

    public static final Object get(String key){
        System.out.println("开始读取数据");
        readLock.lock();
        try {
            return cacheMap.get(key);
        } finally {
            readLock.unlock();
        }

    }

    public static final Object put(String key,String value){
        writeLock.lock();
        System.out.println("开始写数据");
        try {
            return cacheMap.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
}
