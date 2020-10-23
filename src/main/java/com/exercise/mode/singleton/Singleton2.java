package com.exercise.mode.singleton;

/**
 * @ClassName Singleton1
 * @Description 懒汉式
 * @Author yeqiang
 * @Date 2020/10/11 6:28 下午
 * @Version 1.0
 **/
public final class Singleton1 {

    private byte[] data = new byte[1024];

    private static Singleton1 singleton1 = null;

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if (singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
