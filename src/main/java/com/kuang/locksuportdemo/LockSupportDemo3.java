package com.kuang.locksuportdemo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: xuzhi
 * @date: 2020/11/4 14:15
 */
public class LockSupportDemo3 {
    public static void main(String[] args) {
      Thread a=   new Thread(()->{
          System.out.println(Thread.currentThread().getName()+"\t come in");
          LockSupport.park();
          LockSupport.park();
          System.out.println(Thread.currentThread().getName()+"\t 被释放");
        },"A");
      a.start();

      new Thread(()->{
          LockSupport.unpark(a);
          LockSupport.unpark(a);
          System.out.println(Thread.currentThread().getName()+"\t 通知");
      },"B").start();
    }

}
