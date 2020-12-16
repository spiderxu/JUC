package com.kuang.function;

import java.util.function.Function;

public class Demo01 {
    public static void main(String[] args) {
 /*       Function<String,String> function=new Function<String,String>(){

            @Override
            public String apply(String s) {
                return s;
            }
        };*/
  Function<String,String> function=(str)->{return  str;};


        System.out.println(function.apply("asd"));
    }
}
