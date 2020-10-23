package com.exercise.mode.singleton;

/**
 * @ClassName Singleton2
 * @Description 懒汉式 + 同步方法
 * @Author yeqiang
 * @Date 2020/10/11 6:28 下午
 * @Version 1.0
 **/
public final class Singleton2 {

    private byte[] data = new byte[1024];

    private static Singleton2 singleton1 = null;

    private Singleton2(){

    }

    public static synchronized Singleton2 getInstance(){
        if (singleton1 == null){
            singleton1 = new Singleton2();
        }
        return singleton1;
    }
}
