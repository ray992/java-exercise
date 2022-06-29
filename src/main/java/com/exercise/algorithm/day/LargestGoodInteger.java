package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName LargestGoodInteger
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/8 10:31 AM
 * @Version 1.0
 **/
public class LargestGoodInteger {

    public String largestGoodInteger(String num) {
        String[] matchs = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
        List<String> resList = new ArrayList<>();
        for (String match:matchs){
            if (num.contains(match)){
                resList.add(match);
            }
        }
        if (resList.size() == 0){
            return "";
        }
        Collections.sort(resList);
        return resList.get(resList.size() - 1);
    }

    public static void main(String[] args) {

    }
}
