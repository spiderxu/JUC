package com.kuang.threadLocal;

/**
 * Author: 徐志
 * Date: 2020/8/9 10:59
 */

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用，用来管理直接内存，凡是虚引用指向的对象，在垃圾回收的时候会先将对象
 * 放到队列里
 */
public class PhantomReferenceTest {

    private static final List<Object> LIST=new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE=new ReferenceQueue<>();

    //运行前指定堆内存为20M
    public static void main(String[] args) {
        PhantomReference<M> phantomReference=new PhantomReference<>(new M(),QUEUE);
        System.out.println(phantomReference.get());

        new Thread(()->{
            while (true){
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(()->{
            Reference<? extends M> poll=QUEUE.poll();
            if (poll!=null){
                System.out.println("虚引用对象被JVM回收了"+poll);
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
