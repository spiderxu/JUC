package com.whpu.thread.threadCreate;

import org.junit.Test;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:40
 */
public class MyThreadTest {

    @Test
    public void test() throws InterruptedException {
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        myThread1.start();
        myThread2.start();

        //等待一下
        Thread.sleep(500);
    }
}
