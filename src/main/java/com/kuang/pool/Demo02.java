package com.kuang.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: xuzhi
 * @date: 2020/10/17 18:12
 */
public class Demo02 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1线程
       // ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个线程
       // ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for(int i=0;i<10;i++){
                //使用线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"==>"+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
