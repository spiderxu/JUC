package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:59
 */
public class Client {
    public static void main(String[] args) {
        Request request=new Request();
        request.setName("这是一个请求");

        RequestProcessor saveProcessor=new SaveProcessor();
        RequestProcessor printProcessor=new PrintProcessor(saveProcessor);
        RequestProcessor preProcessor=new PreProcessor(printProcessor);

        preProcessor.processRequest(request);
    }
}
