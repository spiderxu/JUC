package com.kuang.pc;

public class Test {
    public static void main(String[] args) {
        Data data=new Data();

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
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}

class Data{
    private int number=0;

    public synchronized void increment() throws InterruptedException {
        if(number!=0){   //会出现虚假唤醒的情况
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if(number==0){
            //等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }
}
