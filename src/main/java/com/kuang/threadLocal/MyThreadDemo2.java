package com.kuang.threadLocal;

/**
 * Author: 徐志
 * Date: 2020/8/9 14:59
 */

/**
 * 使用synchronized关键字解决
 */
public class MyThreadDemo2 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyThreadDemo2 demo=new MyThreadDemo2();
        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    //性能降低，程序失去并发性，串行执行
                    synchronized (MyThreadDemo2.class){
                    demo.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println("===============");
                    System.out.println(Thread.currentThread().getName()+"-->"+demo.getContent());
                }}
            });
            thread.setName("线程"+i);
            thread.start();
        }
    }
}
