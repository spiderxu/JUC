package com.whpu.zookeeper.responityChain.v2;

/**
 * @author: xuzhi
 * @date: 2020/12/7 18:32
 */
public interface IRequestProcessor {
    void processRequest(Request request);
}
