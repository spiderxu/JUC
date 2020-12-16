package com.kuang.function;

import java.util.function.Consumer;

public class Demo03 {
    /**
     * COnsumer 消费型接口：只有输入，没有输出
     * @param args
     */
    public static void main(String[] args) {
        /*
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }; */

        Consumer<String> consumer=(str)->{
            System.out.println(str);
        };

        consumer.accept("aaaaaaaa");
    }
}
