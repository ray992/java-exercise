package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FizzBuzz
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/14 上午9:33
 * @Version 1.0
 **/
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (i % 3 == 0 && i % 5 == 0){
                resList.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0){
                resList.add("Fizz");
                continue;
            }
            if (i % 5 == 0){
                resList.add("Buzz");
                continue;
            }
            resList.add(String.valueOf(i));
        }
        return resList;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(3));
        System.out.println(fizzBuzz.fizzBuzz(5));
        System.out.println(fizzBuzz.fizzBuzz(15));
    }
}
