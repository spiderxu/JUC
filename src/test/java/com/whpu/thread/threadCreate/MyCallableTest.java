package com.whpu.thread.threadCreate;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:51
 */
public class MyCallableTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        MyCallable myCallable=new MyCallable();
        FutureTask futureTask=new FutureTask(myCallable);

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        Integer o = (Integer)futureTask.get();
        System.out.println(o);
    }
}
