package com.kuang.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         //test1();
        //test2();
        test3();
    }

    //普通
    public static void test1(){
        Long sum=0L;
        long start=System.currentTimeMillis();
        for(Long i=1L;i<10_0000_0000;i++){
            sum+=i;
        }

        long end=System.currentTimeMillis();
        System.out.println("时间="+(end-start));
    }

    //ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();

        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);

        Long sum = submit.get();

        long end=System.currentTimeMillis();
        System.out.println("时间="+(end-start));
    }

    public static void test3(){
        long start=System.currentTimeMillis();

        //stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("时间="+(end-start));
    }
}
