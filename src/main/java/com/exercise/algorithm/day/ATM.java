package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ATM
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 11:02 PM
 * @Version 1.0
 **/
public class ATM {

    int[] cash = {20, 50, 100, 200, 500};
    Map<Integer, Integer> cashMap = null;

    public ATM() {
        cashMap = new HashMap<>();
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++){
            cashMap.put(cash[i], cashMap.getOrDefault(cash[i], 0)+banknotesCount[i]);
        }
    }

    public int[] withdraw2(int amount) {
        int[] num = new int[cash.length];
        for (int i = cash.length - 1; i>=0; i--){
            num[i] = Math.min(amount / cash[i], cashMap.getOrDefault(cash[i], 0));
            amount = amount - num[i]*cash[i];
        }
        if (amount > 0){
            return new int[]{-1};
        }
        for (int i = 0; i < num.length; i++){
            cashMap.put(cash[i], cashMap.get(cash[i]) - num[i]);
        }
        return num;
    }

    public int[] withdraw(int amount) {
        int[] num = new int[5];
        int left = amount;
        boolean useStatus  = false;
        for (int i = 4; i>= 0; i--){
            if (left < cash[i]){
                continue;
            }
            int sn = left / cash[i];
            int cn = cashMap.get(cash[i]);
            if (cn == 0 && useStatus){
               continue;
            }
           if (sn <= cn){
               left = left - sn*cash[i];
               num[i] = sn;
           }else {
               left = left - cn*cash[i];
               num[i] = cn;
           }
            if (left == 0){
                break;
            }
            useStatus = true;
        }
        boolean ss = true;
        for (int i = 0; i < num.length; i++){
            if (num[i] < 0){
                ss = false;
                break;
            }
        }
        if (!ss){
            return new int[]{-1};
        }
        if (left > 0){
            return new int[]{-1};
        }
        for (int i = 0; i < num.length; i++){
            cashMap.put(cash[i], cashMap.get(cash[i]) - num[i]);
        }
        return num;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{250796,638723,691758,845522,938973});
        atm.deposit(new int[]{215317,848628,182949,784609,30472});
        //System.out.println(Arrays.toString(atm.withdraw(600)));
        //atm.deposit(new int[]{0,1,0,1,1});
        //System.out.println(Arrays.toString(atm.withdraw(600)));
        //System.out.println(Arrays.toString(atm.withdraw(550)));
        System.out.println(Arrays.toString(atm.withdraw(722349970)));
    }
}
