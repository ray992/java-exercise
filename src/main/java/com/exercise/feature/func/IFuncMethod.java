package com.exercise.feature.func;

@FunctionalInterface
public interface IFuncMethod {

    //函数式接口要求只有一个抽象方法
    void test();

    //静态方法,修饰符默认是public，且只能是public
    static void test1(){
        System.out.println("static method");
    }

    //默认方法， 修饰符默认是public， 且只能为public
    default void testDefault(){
        System.out.println("default method");
    }
}
