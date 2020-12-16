package com.kuang.volatiledemo;

/**
 * @author: xuzhi
 * @date: 2020/11/3 10:42
 */
public class DoubleCheckDemo {
    private volatile static DoubleCheckDemo instance = null;

    private DoubleCheckDemo() {
        System.out.println(Thread.currentThread().getName() + "构造方法");
    }

    public static DoubleCheckDemo getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckDemo.class) {
                if (instance == null) {
                    instance = new DoubleCheckDemo();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
