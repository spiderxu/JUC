package com.whpu.zookeeper.responityChain.v2;

/**
 * @author: xuzhi
 * @date: 2020/12/7 18:44
 */
public class Client {

   static IRequestProcessor requestProcessor;

    public Client(){

    }

    public void setUp(){
        SaveProcessor saveProcessor=new SaveProcessor();
        saveProcessor.start();

        PrintProcessor printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();

        requestProcessor=new PreProcessor(printProcessor);
        ((PreProcessor)requestProcessor).start();
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.setUp();

        Request request=new Request();
        request.setName("xuzhi");
        requestProcessor.processRequest(request);

    }
}
