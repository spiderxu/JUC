package com.kuang.threadLocal;

/**
 * Author: 徐志
 * Date: 2020/8/9 14:59
 */

/**
 * 线程不隔离
 */
public class ThreadLocalDemo {

    ThreadLocal<String> tl=new ThreadLocal<>();
    //private String content;

    public String getContent() {
        return tl.get();
    }

    public void setContent(String content) {
        tl.set(content);
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo=new ThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println("===============");
                    System.out.println(Thread.currentThread().getName()+"-->"+demo.getContent());
                }
            });
            thread.setName("线程"+i);
            thread.start();
        }
    }
}
