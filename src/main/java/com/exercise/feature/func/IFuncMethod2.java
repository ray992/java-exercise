package com.exercise.feature.func;

public interface IFuncMethod2 {

    //默认方法， 修饰符默认是public， 且只能为public
    default void testDefault(){
        System.out.println("default method");
    }
}
