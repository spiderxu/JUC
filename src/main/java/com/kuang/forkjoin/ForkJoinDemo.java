package com.kuang.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 如何使用forkJoin
 * 1.forkjoinPool 通过它来执行
 * 2.计算任务forkjoinPool.execute(ForkJoinTask task)
 * 3.计算类要继承ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    private Long temp=10000L;

    public ForkJoinDemo(Long start,Long end){
        this.start=start;
        this.end=end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if((end-start)<temp){
            Long sum=0L;
            for(Long i=start;i<end;i++){
                sum+=i;
            }
            return sum;
        }else {
            Long mid=start+(end-start)/2; //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork();  //拆分任务
            ForkJoinDemo task2 = new ForkJoinDemo(mid, end);
            task2.fork();

           return  task1.join()+task2.join();

        }

    }
}
