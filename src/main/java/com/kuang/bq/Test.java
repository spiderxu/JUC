package com.kuang.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 测试阻塞队列四组API
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    public static void test1(){
        /**
         * 抛出异常
         */
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("d"));

        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();


    }

    public static void test2(){
        /**
         * 不抛异常
         */
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }

    public static void test3() throws InterruptedException {
        /**
         * 一直阻塞
         */
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.put("d");


        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

    }

    public static void test4() throws InterruptedException {
        /**
         * 超时等待
         */
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d",2,TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }
}
