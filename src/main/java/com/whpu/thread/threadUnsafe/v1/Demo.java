package com.whpu.thread.threadUnsafe.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/8 16:03
 * 多线程不安全
 */
public class Demo {

    private static int count=0;

    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->Demo.inc()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果："+count);
    }
}
