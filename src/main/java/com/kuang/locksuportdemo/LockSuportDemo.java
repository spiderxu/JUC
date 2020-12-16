package com.kuang.locksuportdemo;

import java.util.concurrent.TimeUnit;

/**
 * @author: xuzhi
 * @date: 2020/11/4 10:50
 */
public class LockSuportDemo {
    static Object objectLock=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName()+"\t come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t 被唤醒");
            }
        },"A").start();

        new Thread(()->{
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"\t 通知");
            }
        },"B").start();
    }
}
