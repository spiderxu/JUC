package com.whpu.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xuzhi
 * @date: 2020/12/11 10:01
 * ReentrantLock能够保证原子性
 */
public class ReentrantLockIsAtomic {
    private static int count=0;
    static Lock lock=new ReentrantLock();
    public static void increase(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{ReentrantLockIsAtomic.increase();}).start();
        }

        Thread.sleep(3000);
        System.out.println(count);
    }
}
