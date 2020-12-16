package com.kuang.threadLocal;

import java.lang.ref.SoftReference;

/**
 * Author: 徐志
 * Date: 2020/8/9 10:35
 * 软引用
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);

        System.out.println(m.get());
        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        //再分配一个数组，这是会堆装不下，系统会执行垃圾回收
        byte[] b=new byte[1024*1024*15];
        System.out.println(m.get());
    }

}
//软引用适合做缓存