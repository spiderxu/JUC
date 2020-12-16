package com.kuang.add;

import java.util.concurrent.CountDownLatch;

/**
 * Author: 徐志
 * Date: 2020/8/8 16:44
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(2);

        new Thread(()->{
            System.out.println("刘备--》在等待");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("刘关张桃园三结义");
        }).start();

        new Thread(()->{
            System.out.println("张飞--》骑马而来");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("张飞拜见大哥");
            countDownLatch.countDown();

        }).start();

        new Thread(()->{
            System.out.println("关羽--》骑马而来");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("关羽拜见大哥");
            countDownLatch.countDown();

        }).start();
    }
}
