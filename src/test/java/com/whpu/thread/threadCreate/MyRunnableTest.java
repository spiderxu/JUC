package com.whpu.thread.threadCreate;

import org.junit.Test;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:51
 */
public class MyRunnableTest  {
    @Test
    public void test() throws InterruptedException {
       MyRunnable myRunnable1=new MyRunnable();
       MyRunnable myRunnable2=new MyRunnable();

        new Thread(myRunnable1,"A").start();
        new Thread(myRunnable2,"B").start();

        //等待一下
        Thread.sleep(500);
    }
}
