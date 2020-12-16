package com.kuang.oom;

/**
 * @author: xuzhi
 * @date: 2020/10/27 15:09
 */
public class StackOverFlowErrorDemo {

    public static void main(String[] args) {
        stackOverFlow();
    }

    static void stackOverFlow(){
        stackOverFlow();
    }
}
