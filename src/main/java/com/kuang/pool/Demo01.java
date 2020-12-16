package com.kuang.pool;

import java.util.concurrent.*;

//Executors工具类
public class Demo01 {
    public static void main(String[] args) {

        //自定义线程类
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());  //银行满了，还有人进来，不处理


        try {
            //最大承载：Deque+max;
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
