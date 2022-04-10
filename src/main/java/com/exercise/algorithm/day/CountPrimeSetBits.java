package com.exercise.algorithm.day;

import lombok.var;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName CountPrimeSetBits
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/5 12:14 PM
 * @Version 1.0
 **/
public class CountPrimeSetBits {

    public int countPrimeSetBits(int left, int right) {
        List<Integer> countList = new ArrayList<>();
        for (int i = left; i <= right; i++){
            String binaryString = Integer.toBinaryString(i);
            int n = 0;
            for (char c:binaryString.toCharArray()){
                if (c == '1'){
                    n++;
                }
            }
            countList.add(n);
        }
        int sum = 0;
        for (Integer count:countList){
            if (count < 2){
                continue;
            }
            boolean status = true;
            for (var i = 2; i <= Math.sqrt(count); i++){
                if (count % i == 0){
                    status = false;
                    break;
                }
            }
            if (status){
                sum ++;
            }
        }
        return sum;
    }

    public int countPrimeSetBits2(int left, int right){
        int ans = 0;
        for (int i = left; i <= right; i++){
            if ( ((1 << Integer.bitCount(i)) & 665772) != 0){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        //System.out.println(countPrimeSetBits.countPrimeSetBits(1, (int)1e6));
        //System.out.println(countPrimeSetBits.countPrimeSetBits(6, 10));
        //System.out.println(countPrimeSetBits.countPrimeSetBits(10, 15));
        System.out.println(countPrimeSetBits.countPrimeSetBits(990, 1048));
        System.out.println(Integer.bitCount(100));
    }
}
