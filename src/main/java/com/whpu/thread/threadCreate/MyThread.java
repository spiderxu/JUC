package com.whpu.thread.threadCreate;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:38
 * 创建线程的方式一：继承Thread类
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

}
