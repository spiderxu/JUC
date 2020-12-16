package com.kuang.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xuzhi
 * @date: 2020/10/14 9:34
 */
public class AtomicIntegerDemo {

   static AtomicInteger num=new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                   num.getAndIncrement();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"任务完成");
            },i+"").start();

        }

        //让main线程等待一下
        Thread.sleep(1000);
        System.out.println(num);
    }
}
