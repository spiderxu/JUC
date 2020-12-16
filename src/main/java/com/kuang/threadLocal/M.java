package com.kuang.threadLocal;

/**
 * Author: 徐志
 * Date: 2020/8/9 10:25
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
