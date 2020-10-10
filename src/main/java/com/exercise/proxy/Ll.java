package com.exercise.proxy.jdk;

/**
 * @ClassName Ll
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/10 8:44 上午
 * @Version 1.0
 **/
public class Ll implements Star {


    @Override
    public void sing(String name) {
        System.out.println(name + " "+ "sing");
    }

    @Override
    public void dance(String name) {
        System.out.println(name + " "+ "dance");
    }
}
