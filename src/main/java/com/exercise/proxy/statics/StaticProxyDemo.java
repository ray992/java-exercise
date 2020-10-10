package com.exercise.proxy;

/**
 * @ClassName StaticProxyDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/9 9:58 下午
 * @Version 1.0
 **/
public class StaticProxyDemo {

    public static void main(String[] args) {
        IUserDAOImpl iUserDAO = new IUserDAOImpl();
        UserProxy userProxy = new UserProxy(iUserDAO);
        userProxy.save();
    }
}

