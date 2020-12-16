package com.whpu.zookeeper.responityChain.v2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: xuzhi
 * @date: 2020/12/7 18:33
 */
public class SaveProcessor extends Thread implements IRequestProcessor {

    LinkedBlockingQueue<Request> requests=new LinkedBlockingQueue<>();

    private volatile boolean isFinish=false;

    public void shoutDown(){
        isFinish=true;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request request = requests.take();
                System.out.println("保存数据");
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
