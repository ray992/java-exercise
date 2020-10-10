package com.exercise.proxy.cglib;

import com.exercise.proxy.Ll;
import com.exercise.proxy.Star;

/**
 * @ClassName CglibDemo
 * @Description cglib 测试
 * @Author yeqiang
 * @Date 2020/10/10 9:12 上午
 * @Version 1.0
 **/
public class CglibDemo {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Ll star = (Ll) cglibProxy.createProxyObject(Ll.class);
        star.sing("bb");
        star.dance("cc");
        star.info();
    }
}
