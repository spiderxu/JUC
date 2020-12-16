package com.kuang.function;

import java.util.function.Predicate;

public class Test02 {
    /**
     * 断定型接口，有一个输入参数，返回值只能是布尔值
     * @param args
     */
    public static void main(String[] args) {
        /*//判断字符串是否为空
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };*/

        Predicate<String> predicate=(str)->{return str.isEmpty();};
        System.out.println(predicate.test(""));

    }
}
