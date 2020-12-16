package com.whpu.reentrantLock;

/**
 * @author: xuzhi
 * @date: 2020/12/11 9:55
 * 重入锁
 */
public class ReentrantDemo {

    public synchronized void demo1(){
        System.out.println("begin:demo1");
        demo2();
    }

    public void demo2(){
        System.out.println("begin:demo2");
        synchronized (this){

        }
    }

    public static void main(String[] args) {
        ReentrantDemo reentrant=new ReentrantDemo();
        //new Thread(reentrant::demo1).start();
        reentrant.demo1();
    }

}
