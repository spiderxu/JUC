package com.kuang.lock8;

/**
 * @author: xuzhi
 * @date: 2020/10/16 14:23
 */
public class DeadLockDemo {
    public static Object lockA=new Object();
    public static Object lockB=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName()+"持有A锁，等待B锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("线程A完成");
                }
            }
        },"线程A").start();

        new Thread(()->{
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"持有B锁，等待A锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println("线程B完成");
                }
            }
        },"线程B").start();
    }
}
