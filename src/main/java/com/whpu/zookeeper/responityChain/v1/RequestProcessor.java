package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:45
 */
public interface RequestProcessor {

    void processRequest(Request request);
}
