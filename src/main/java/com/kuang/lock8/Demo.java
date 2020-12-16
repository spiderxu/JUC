package com.kuang.lock8;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);  //main线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.hello();
        },"B").start();
    }

}

class Phone{
    //两个方法用的是同一个锁，谁先拿到谁先执行，所以发短信先输出
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}