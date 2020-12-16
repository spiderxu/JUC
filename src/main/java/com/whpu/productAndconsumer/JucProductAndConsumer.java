package com.whpu.productAndconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xuzhi
 * @date: 2020/12/8 17:58
 * Lock方式的生产者和消费者问题
 */
public class JucProductAndConsumer {
    public static void main(String[] args) {
        Data2 data=new Data2();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();



        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class Data2{
    private int number=0;

    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();

        try {
            while(number!=0){   //会出现虚假唤醒的情况
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void decrement() throws InterruptedException {
        lock.lock();

        try {
            while(number==0){   //使用if会出现虚假唤醒的情况
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}