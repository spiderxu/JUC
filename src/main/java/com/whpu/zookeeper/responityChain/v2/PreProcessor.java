package com.whpu.zookeeper.responityChain.v2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: xuzhi
 * @date: 2020/12/7 18:32
 */
public class PreProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> requests=new LinkedBlockingQueue<>();

    private volatile boolean isFinish=false;

    private IRequestProcessor nextProcessor;

    public PreProcessor(IRequestProcessor nextProcessor){
        this.nextProcessor=nextProcessor;
    }

    public void shoutDown(){
        isFinish=true;
    }

    @Override
    public void run() {
        while (!isFinish){
            try {
                Request request = requests.take();
                System.out.println("预处理数据");
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
