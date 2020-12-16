package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:49
 */
public class SaveProcessor implements RequestProcessor{
    @Override
    public void processRequest(Request request) {
        System.out.println("保存数据");
    }
}
