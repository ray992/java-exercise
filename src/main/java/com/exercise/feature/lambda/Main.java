package com.exercise.feature.lambda;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/22 4:16 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        ILambda1 lambda1 = new ILambda1() {
            @Override
            public void test() {
                System.out.println("test1");
            }
        };
        ILambda1 lambda12 = () ->{
            System.out.println("lambda");
        };
        lambda1.test();
        lambda12.test();
        ILambda1 lambda13 = () -> System.out.println("lambda");
        lambda13.test();

        ILambda2 iLambda2 = (s) -> System.out.println("lambda:"+s);
        iLambda2.test("only one param");

        ILambda3 iLambda3 = (s, i) -> System.out.println("lambda:"+s+" "+i);
        iLambda3.test("one param", 2);
    }
}
