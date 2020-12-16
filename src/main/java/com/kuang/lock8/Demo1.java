package com.kuang.lock8;

import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        Phone1 phone=new Phone1();


        new Thread(()->{
            phone.sendSms();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();




    }
}

class Phone1{
    //static 静态方法，锁的是.class文件
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public  synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }

}