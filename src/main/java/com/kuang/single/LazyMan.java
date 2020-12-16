package com.kuang.single;

//懒汉式
public class LazyMan {
    private LazyMan(){

    }

    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }

        return lazyMan;
    }
}
