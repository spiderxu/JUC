package com.kuang.function;

import java.util.function.Supplier;

public class Demo04 {
    /**
     * Supplier 供给型接口，没有参数,只有返回值
     * @param args
     */
    public static void main(String[] args) {
        /*Supplier<Integer> supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1024;
            }
        };*/

        Supplier supplier=()->{return 1024;};
        System.out.println(supplier.get());
    }
}
