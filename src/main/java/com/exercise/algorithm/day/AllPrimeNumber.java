package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AllPrimeNumber
 * @Description 输入所有小于n的质数
 * @Author yeqiang
 * @Date 2021/11/11 下午9:25
 * @Version 1.0
 **/
public class AllPrimeNumber {

    public List<Integer> getAllPrimeNumber(int n){
        List<Integer> resultList = new ArrayList<>();
        for (int i = 2; i < n; i++)
        {
            boolean sign = true;
            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        AllPrimeNumber  allPrimeNumber = new AllPrimeNumber();
        System.out.println(allPrimeNumber.getAllPrimeNumber(100));
        System.out.println(7&(8-1));
        System.out.println(7%8);
    }
}
