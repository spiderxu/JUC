package com.kuang.locksuportdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xuzhi
 * @date: 2020/11/4 11:11
 */
public class LockSupportDemo2 {
    static Lock lock=new ReentrantLock();
    static Condition condition=lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }finally {
               lock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"\t 被唤醒");
        },"A").start();

        new Thread(()->{
             lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\t 通知" );

            }finally {
              lock.unlock();
            }

        },"B").start();
    }
}
