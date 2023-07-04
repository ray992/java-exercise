package com.exercise.algorithm.competition.nio;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PeopleAwareOfSecret
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/3 11:19 AM
 * @Version 1.0
 **/
public class PeopleAwareOfSecret {

    public static  int MOD = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Map<Integer, Long> countMap = new HashMap<>();
        //记录第几天产生的新人
        countMap.put(1, 1L);
        Map<Integer, Long> tempMap = new HashMap<>();
        for (int i = 1; i <= n; i++){
           tempMap.clear();
           for (Map.Entry<Integer, Long> map:countMap.entrySet()){
               Integer day = map.getKey();
               Long count = map.getValue();
               if (i - day >= forget){
                   tempMap.put(day, 0L);
                   continue;
               }
               if ((i - day) >= delay){
                   tempMap.put(i, (tempMap.getOrDefault(i, 0L)+count%MOD) % MOD);
               }
           }
            countMap.putAll(tempMap);
        }
        int result = 0;
        for (Map.Entry<Integer, Long> map:countMap.entrySet()){
            Long count = map.getValue();
            result = (int) (result + count % MOD) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        PeopleAwareOfSecret peopleAwareOfSecret = new PeopleAwareOfSecret();
        //System.out.println(peopleAwareOfSecret.peopleAwareOfSecret(6, 2, 4));
        //System.out.println(peopleAwareOfSecret.peopleAwareOfSecret(4, 1, 3));
        System.out.println(peopleAwareOfSecret.peopleAwareOfSecret(684, 18, 496));
    }
}
