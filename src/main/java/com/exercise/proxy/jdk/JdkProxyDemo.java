package com.exercise.proxy.jdk;

import com.exercise.proxy.Star;
import com.exercise.proxy.Ll;

/**
 * @ClassName JdkProxyDemo
 * @Description jdk代理测试
 * @Author yeqiang
 * @Date 2020/10/10 8:50 上午
 * @Version 1.0
 **/
public class JdkProxyDemo {

    public static void main(String[] args) {
        Star star = new Ll();
        StarProxy starProxy = new StarProxy();
        starProxy.setObject(star);
        Object proxyObject = starProxy.createProxyObject();
        Star proxyStar = (Star)proxyObject;
        proxyStar.dance("aa");
    }
    //代理类不能直接包含被代理的对象， 而是一个InvocationHandler, InvocationHandler包含被代理的对象， 并负责分发请求给代理对象， 分发前后都可以做增强
}
