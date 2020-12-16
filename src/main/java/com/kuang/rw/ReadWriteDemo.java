package com.kuang.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for(int i=1;i<=5;i++){
             int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for(int i=1;i<=5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }

}

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    Lock lock=new ReentrantLock(true);

    //存，写
    public synchronized  void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //取，读
    public void get(String key){
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}