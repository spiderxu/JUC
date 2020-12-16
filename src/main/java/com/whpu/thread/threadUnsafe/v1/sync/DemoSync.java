package com.whpu.thread.threadUnsafe.v1.sync;

import com.whpu.thread.threadUnsafe.v1.Demo;

/**
 * @author: xuzhi
 * @date: 2020/12/8 16:08
 * 使用synchronized关键字
 */
public class DemoSync {
    private static int count=0;

    public  static void inc(){
        synchronized (DemoSync.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> DemoSync.inc()).start();
        }
        Thread.sleep(3000);

        System.out.println("运行结果："+count);
    }
}
