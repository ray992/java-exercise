package com.exercise.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description Cglib 代理类定义
 * @Author yeqiang
 * @Date 2020/10/10 9:09 上午
 * @Version 1.0
 **/
public class CglibProxy implements MethodInterceptor {

    //产生一个代理类
    public Object createProxyObject(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("earn money");
        return methodProxy.invokeSuper(o, objects);
    }
}
