package com.kuang.cas;

/**
 * @author: xuzhi
 * @date: 2020/10/14 9:16
 */
public class Demo {
     static volatile int num=0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    num++;
                }
                System.out.println("线程"+Thread.currentThread().getName()+"任务完成");
            },i+"").start();

        }

        //让main线程等待一下
        Thread.sleep(1000);
        System.out.println(num);
    }
}
