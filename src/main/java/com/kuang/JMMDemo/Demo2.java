package com.kuang.JMMDemo;

import java.util.concurrent.atomic.AtomicInteger;

/*
不保证原子性
 */
public class Demo2 {
    private volatile  static AtomicInteger number=new AtomicInteger();

    public static  void add(){
        number.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"=>"+number);
    }
}
