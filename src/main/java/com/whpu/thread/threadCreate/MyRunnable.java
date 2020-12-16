package com.whpu.thread.threadCreate;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:46
 * 线程创建方式二：实现Runnable接口
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }
}
