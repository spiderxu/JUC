package com.kuang.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Author: 徐志
 * Date: 2020/8/9 11:35
 */
public class ThreadLocalTest2 {
    static ThreadLocal<Person> t1=new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t1.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //每个线程对应一个map，线程与线程之间互不影响
            t1.set(new Person());
        }).start();
    }

    static class Person{
        String name="zhangsna";
    }
}
