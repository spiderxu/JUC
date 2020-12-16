package com.whpu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author: xuzhi
 * @date: 2020/12/8 17:48
 * 锁静态方法
 */
public class SyncStatic {
    public static void main(String[] args) {
        Phone3 phone=new Phone3();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);  //main线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone3{
    //static 静态方法，锁的是.class文件
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}
