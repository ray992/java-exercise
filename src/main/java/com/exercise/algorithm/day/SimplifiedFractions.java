package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SimplifiedFractions
 * @Description 最简分数
 * @Author yeqiang
 * @Date 2022/2/10 上午9:28
 * @Version 1.0
 **/
public class SimplifiedFractions {

    //最大公约数是否为1，则是最简分数
    public List<String> simplifiedFractions(int n) {
        List<String> resultList = new ArrayList<>();
        int start = 1;
        while (start <= n){
            for (int i = 1; i < start; i++){
                if (i > 1 &&  exist(start, i)){
                    continue;
                }
                resultList.add(i + "/" + start);
            }
            start++;
        }
        return resultList;
    }

    public boolean exist(int x, int y){
        int bigNumber = Math.max(x, y);
        int smallNumber = Math.min(x, y);
        if (bigNumber % smallNumber == 0){
            return true;
        }
        bigNumber = bigNumber % smallNumber;
        if (bigNumber == 1){
            return false;
        }
        return exist(bigNumber % smallNumber, smallNumber);
    }

    public static void main(String[] args) {
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        System.out.println(simplifiedFractions.simplifiedFractions(1));
        System.out.println(simplifiedFractions.simplifiedFractions(2));
        System.out.println(simplifiedFractions.simplifiedFractions(3));
        System.out.println(simplifiedFractions.simplifiedFractions(4));
        System.out.println(simplifiedFractions.simplifiedFractions(6));
        System.out.println(simplifiedFractions.simplifiedFractions(8));
        System.out.println(simplifiedFractions.simplifiedFractions(21));
        //System.out.println(simplifiedFractions.simplifiedFractions(100));
        //System.out.println(simplifiedFractions.exist(7,5));
        //System.out.println(simplifiedFractions.exist(1331,121));
    }
}
