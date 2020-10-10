package com.exercise.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName StarProxy
 * @Description jdk代理类定义
 * @Author yeqiang
 * @Date 2020/10/10 8:46 上午
 * @Version 1.0
 **/
public class StarProxy implements InvocationHandler {

    //目标类
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("earn money"); //增强
        method.invoke(object, args);
        return null;
    }

    //生成代理类
    public Object createProxyObject(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
}
