package com.kuang.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        //Map<String,String> map=new HashMap<>();
        //Map<String,String> map=new Hashtable<>();
        //Map<String,String> map= Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map=new ConcurrentHashMap<>();

        for(int i=1;i<40;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
