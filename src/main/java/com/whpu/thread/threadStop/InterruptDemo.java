package com.whpu.thread.threadStop;

import java.util.concurrent.TimeUnit;

/**
 * @author: xuzhi
 * @date: 2020/12/8 9:24
 * 线程中断的方式一：调用interrupt方法
 */
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
       Thread thread= new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
           System.out.println("i:"+i);

        },"interruptDemo");

       thread.start();
        TimeUnit.SECONDS.sleep(1);

        //不加这一行代码，线程不会停止
        thread.interrupt();
    }
}
