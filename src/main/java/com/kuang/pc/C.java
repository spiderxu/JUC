package com.kuang.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data=new Data3();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                data.printC();
            }
        },"C").start();
    }
}


class  Data3{
    private Lock lock=new ReentrantLock();  //锁
    private Condition condition1=lock.newCondition();  //同步监视器
    private Condition condition2=lock.newCondition();  //同步监视器
    private Condition condition3=lock.newCondition();  //同步监视器


    private int number=1;

    public void printA(){
        lock.lock();

        try {
            while(number!=1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"==>AAAAAAA");
            number=2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public  void  printB(){
        lock.lock();

        try {
            while(number!=2){
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"==>BBBBB");
            number=3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();

        try {
            while(number!=3){
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"==>CCCCCCCC");
            number=1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}