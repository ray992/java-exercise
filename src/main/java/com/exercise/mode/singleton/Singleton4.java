package com.exercise.mode.singleton;

/**
 * @ClassName Singleton2
 * @Description Holder方式
 * @Author yeqiang
 * @Date 2020/10/11 6:28 下午
 * @Version 1.0
 **/
public final class Singleton3 {

    private byte[] data = new byte[1024];

    private Singleton3(){

    }

    private static class Holder{
        private static Singleton3 singleton3 = new Singleton3();
    } //当Holder被主动引用当时候才会创建Singleton3实例

    public static Singleton3 getInstance(){
        return Holder.singleton3;
    }
}
