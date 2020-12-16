package com.kuang.volatiledemo;

/**
 * @author: xuzhi
 * @date: 2020/11/3 10:11
 */
public class SingletonDemo {

    private static SingletonDemo instance=null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"构造方法");
    }

    public static SingletonDemo getInstance(){
        if (instance==null){
            instance = new SingletonDemo();
        }
        return instance;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
