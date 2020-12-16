package com.kuang.rw;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: xuzhi
 * @date: 2020/10/14 15:45
 * 自旋锁
 */

/**
 * 自旋锁：循环比较获取直到成功为止,没有类似wait的阻塞
 *
 * 通过CAS操作完成自旋锁,A线程先进来调用myLock方法自己持有锁5秒钟,B随后进来后发现
 * 当前有线程持有锁,不是null,所以只能通过自旋等待,直到A释放锁后B抢到
 *
 */

public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){

        }
        System.out.println(Thread.currentThread().getName() + "\tget lock.");
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\tinvoke myUnlock().");
    }

    public static void main(String[] args) {
        SpinLockDemo demo = new SpinLockDemo();

        new Thread("t1"){
            @Override
            public void run() {
                demo.myLock();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.myUnlock();
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread("t2"){
            @Override
            public void run() {
                demo.myLock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.myUnlock();
            }
        }.start();
    }

}
