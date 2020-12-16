package com.whpu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author: xuzhi
 * @date: 2020/12/8 17:46
 * 有锁和无锁的情况
 */
public class SyncAndNoSync {
    public static void main(String[] args) {
        Phone2 phone=new Phone2();
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

class Phone2{
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
