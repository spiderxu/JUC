package com.kuang.oom;

import java.util.Random;

/**
 * @author: xuzhi
 * @date: 2020/10/25 15:36
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str="xuzhi";
        while (true){
            str+=str+new Random().nextInt(111111)+new Random().nextInt(222222);
            str.intern();
        }
    }
}
