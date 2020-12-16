package com.kuang.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        //lambda表达式
        new Thread(()->{
            for(int i=0;i<60;i++){
                ticket.sale();
            }

        },"A").start();

        new Thread(()->{
            for(int i=0;i<60;i++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<60;i++){
                ticket.sale();
            }
        },"C").start();
    }

}

//资源类
class Ticket{
    //票数
    private int number=50;

    Lock lock=new ReentrantLock();
    public  void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"张票，还剩"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}