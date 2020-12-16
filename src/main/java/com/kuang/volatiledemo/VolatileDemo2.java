package com.kuang.volatiledemo;

/**
 * @author: xuzhi
 * @date: 2020/11/2 16:56
 */

/**
 * volatile不保证原子性
 */
public class VolatileDemo2 {
    public static void main(String[] args) {
        MyDatas myDatas=new MyDatas();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    myDatas.addPlus();
                }
            },"线程"+i).start();
        }

        while (Thread.activeCount()>2){
            //程序默认有两个线程，一个mian,一个GC
            Thread.yield();
        }

        System.out.println(myDatas.number);
    }
}

class MyDatas{
    volatile int number=0;

    public void addPlus(){
        number++;
    }
}
