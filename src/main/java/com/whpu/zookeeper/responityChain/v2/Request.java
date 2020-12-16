package com.whpu.zookeeper.responityChain.v2;

/**
 * @author: xuzhi
 * @date: 2020/12/7 18:31
 */
public class Request {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
