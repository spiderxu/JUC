package com.kuang.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(8,()->{
            System.out.println("召唤神龙成功");
        });

        for (int i = 1; i <=7 ; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");

                try {
                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        cyclicBarrier.await();
        System.out.println("悟空和他的小伙伴过上了幸福的生活");
    }
}
