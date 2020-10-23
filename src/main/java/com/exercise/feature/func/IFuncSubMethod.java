package com.exercise.feature.func;

//同时继承，必须要重新默认方法
public interface IFuncSubMethod extends IFuncMethod, IFuncMethod2 {
    @Override
    default void test() {

    }

    @Override
    default void testDefault() {
        IFuncMethod2.super.testDefault();
    }
}
