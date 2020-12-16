package com.whpu.thread.threadStatus;

import java.util.concurrent.TimeUnit;

/**
 * @author: xuzhi
 * @date: 2020/12/8 9:07
 */
public class ThreadStatus {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStatus.class){
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"waiting").start();

        new Thread(new BlockedDemo(),"BlockDemo1").start();
        new Thread(new BlockedDemo(),"BlockDemo2").start();

    }




    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
