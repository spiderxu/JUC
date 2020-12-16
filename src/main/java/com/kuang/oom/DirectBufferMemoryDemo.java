package com.kuang.oom;

import java.nio.ByteBuffer;

/**
 * @author: xuzhi
 * @date: 2020/10/25 16:29
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置maxDirectMemory："+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
