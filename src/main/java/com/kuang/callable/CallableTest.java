package com.kuang.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread=new MyThread();
        FutureTask future=new FutureTask(myThread);
        new Thread(future,"A").start();
        new Thread(future,"B").start();

        Integer o = (Integer)future.get(); //这个get方法可能会产生阻塞
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 4399;
    }
}
