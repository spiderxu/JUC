package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:46
 */
public class PrintProcessor implements RequestProcessor {

    private RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor){
        this.nextProcessor=nextProcessor;
    }

    @Override
    public void processRequest(Request request) {
        System.out.println("打印数据");
        /**
         * 打印数据
         */

        nextProcessor.processRequest(request);
    }
}
