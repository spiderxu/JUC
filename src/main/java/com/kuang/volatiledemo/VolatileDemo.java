package com.kuang.volatiledemo;

/**
 * @author: xuzhi
 * @date: 2020/11/2 16:32
 */

import java.util.concurrent.TimeUnit;

/**
 * 验证volatile可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData=new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number value"+myData.number);
        },"AAA").start();

        //如果main线程能够感知到number发生变化，则打印
        while (myData.number==0){

        }

        System.out.println(Thread.currentThread().getName()+"\t is over");
    }
}

class MyData{
    volatile int number=0;

    public void addTo60(){
        this.number=60;
    }
}