package com.whpu.thread.threadCreate;

import java.util.concurrent.Callable;

/**
 * @author: xuzhi
 * @date: 2020/12/7 16:50
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("调用call方法");
        return 4399;
    }
}
