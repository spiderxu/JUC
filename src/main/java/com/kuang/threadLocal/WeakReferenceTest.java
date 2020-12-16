package com.kuang.threadLocal;

import java.lang.ref.WeakReference;

/**
 * Author: 徐志
 * Date: 2020/8/9 10:52
 */

/**
 * 弱引用
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m=new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}
