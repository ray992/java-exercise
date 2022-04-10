package com.exercise;

/**
 * @ClassName Test
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/3/21 12:54 PM
 * @Version 1.0
 **/
public class Test {

    public static Integer count = 0;

    public static void main(String[] args) {
       for (int i = 0; i < 10; i++){
           System.out.println("before exception msg:"+i);
           try {
               int p = 1 / 0;
               System.out.println("execute:"+i);
           }catch (Exception e){
               System.out.println(e);
               throw e;
           }
           System.out.println("after exception msg:"+i);
       }
    }
}
