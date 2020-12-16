package com.kuang.threadLocal;

/**
 * Author: 徐志
 * Date: 2020/8/9 10:27
 */

import java.io.IOException;

/**
 * 强引用
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m=new M();
        m=null;
        System.gc(); //手动调用GC，真正执行还是得看垃圾回收器

        //main线程走完，垃圾回收线程也会退出，就可能出现垃圾会收还没执行运行就已经结束了
        System.in.read();//阻塞main线程，给垃圾回收线程时间执行
    }
}
