package com.kuang.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xuzhi
 * @date: 2020/11/3 9:06
 * 解决volatile不保证原子性的方法二：使用原子类
 */
public class VolatileDemo4 {
    public static void main(String[] args) {
        Da da=new Da();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                  da.addPlus();
                }
            },"线程"+i).start();
        }
        while (Thread.activeCount()>2){
            //程序默认有两个线程，一个main,一个GC
            Thread.yield();
        }
        System.out.println(da.number);
    }
}

class Da{
    AtomicInteger number=new AtomicInteger();

    public void addPlus(){
       number.getAndIncrement();
    }
}
