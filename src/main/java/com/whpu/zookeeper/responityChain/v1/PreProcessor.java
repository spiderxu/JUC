package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:54
 */
public class PreProcessor implements RequestProcessor {

    private RequestProcessor nextRequest;

    public PreProcessor(RequestProcessor nextRequest){
        this.nextRequest=nextRequest;
    }

    @Override
    public void processRequest(Request request) {
        /**
         * 操作数据，预处理
         */

        System.out.println("预处理数据");
        nextRequest.processRequest(request);
    }
}
