package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NthSuperUglyNumber
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/9 上午9:22
 * @Version 1.0
 **/
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1){
            return 1;
        }
        List<Integer> primeList = new ArrayList<>();
        for (int num:primes){
            primeList.add(num);
        }
        int i = 2;
        int startPrime = 2;
        int quotient = 0;
        int remainder = 0;
        int startUglyNumber= 2;
        List<Integer> validUglyNumberList = new ArrayList<>();
        validUglyNumberList.add(1);
        while (i <= n){
            int tempUglyNumber = startUglyNumber;
            int tempPrime = startPrime;
            while (true){
                if (tempPrime > tempUglyNumber){
                    break;
                }
                remainder = tempUglyNumber % tempPrime;
                quotient = tempUglyNumber / tempPrime;
                if (!primeList.contains(tempPrime)){
                    tempPrime++;
                    continue;
                }
                if (quotient == 1 && remainder == 0){
                    validUglyNumberList.add(startUglyNumber);
                    i++;
                    break;
                }
                if (remainder != 0){
                    tempPrime++;
                }else {
                    if (!primeList.contains(startPrime)){
                        break;
                    }else {
                        tempUglyNumber = quotient;
                        tempPrime = startPrime;
                    }
                }
            }
            startUglyNumber++;
        }
        return validUglyNumberList.get(n -1);
    }

    public static void main(String[] args) {
        NthSuperUglyNumber nthSuperUglyNumber = new NthSuperUglyNumber();
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(2, new int[]{2,3,5}));
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(1, new int[]{2,3,5}));
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(10, new int[]{2,3,5}));
    }
}
