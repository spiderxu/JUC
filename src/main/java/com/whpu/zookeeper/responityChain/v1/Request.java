package com.whpu.zookeeper.responityChain.v1;

/**
 * @author: xuzhi
 * @date: 2020/12/7 17:44
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
