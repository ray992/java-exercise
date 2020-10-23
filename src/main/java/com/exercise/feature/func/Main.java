package com.exercise.feature.func;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/22 2:48 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        IStaticMethod.test();

        IFuncMethod iFuncMethod = new IFuncMethod() {
            @Override
            public void test() {
                System.out.println("test 1");
            }
        };
        iFuncMethod.testDefault();
    }
}
