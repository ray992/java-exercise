package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName MapSum
 * @Description 键值映射
 * @Author yeqiang
 * @Date 2021/11/14 下午6:26
 * @Version 1.0
 **/
public class MapSum {

    Map<String, Integer> dataMap = null;

    public MapSum() {
        dataMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        dataMap.put(key, val);
    }

    public int sum(String prefix) {
       Set<String> keySet = dataMap.keySet();
       int total = 0;
       if (keySet.size() > 0){
           for (String curKey : keySet) {
               if (curKey.startsWith(prefix)) {
                   total += dataMap.get(curKey);
               }
           }
       }
       return total;
    }


}
