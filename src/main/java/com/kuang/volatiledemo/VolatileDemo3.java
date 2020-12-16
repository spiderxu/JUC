package com.kuang.volatiledemo;

/**
 * @author: xuzhi
 * @date: 2020/11/3 9:01
 *
 * 解决volatile不能保证原子性的方式一：加 synchroinzed
 */
public class VolatileDemo3 {
    public static void main(String[] args) {
      Data data=new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    data.addPlus();
                }
            },"线程"+i).start();
        }

        while (Thread.activeCount()>2){
            //程序默认有两个线程，一个main,一个GC
            Thread.yield();
        }

        System.out.println(data.number);
    }
}

class Data{
    int number=0;

    public synchronized void addPlus(){
        number++;
    }
}
