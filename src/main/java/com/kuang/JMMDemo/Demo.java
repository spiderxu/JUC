package com.kuang.JMMDemo;

import java.util.concurrent.TimeUnit;

public class Demo {
    private static volatile int number=0;
    public static void main(String[] args) {
        new Thread(()->{
            while(number==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number=1;
        System.out.println(number);
    }
}
