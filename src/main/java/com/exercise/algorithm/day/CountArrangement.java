package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CountArrangement
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/16 下午5:41
 * @Version 1.0
 **/
public class CountArrangement {

    public int countArrangement(int n) {
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i%j ==0 || j%i ==0){
                    if (countMap.containsKey(j)){
                        countMap.get(j).add(i);
                    }else {
                        List<Integer> numList = new ArrayList<>();
                        numList.add(i);
                        countMap.put(j, numList);
                    }
                }
            }
        }
        if (countMap.size() == 0){
            return 0;
        }
        int answer = 1;
        for (Map.Entry<Integer, List<Integer>> map:countMap.entrySet()){
            answer *= map.getValue().size();
        }
        return answer/2;
    }

    public static void main(String[] args) {
        CountArrangement countArrangement = new CountArrangement();
        System.out.println(countArrangement.countArrangement(15));
    }
}
