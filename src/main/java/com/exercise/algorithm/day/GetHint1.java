package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetHint1
 * @Description 猜数字游戏
 * @Author yeqiang
 * @Date 2022/7/7 6:36 PM
 * @Version 1.0
 **/
public class GetHint1 {

    public String getHint(String secret, String guess) {
        int n = secret.length();
        int rightCount = 0;
        Map<Character, Integer> mapCount1 = new HashMap<>();
        Map<Character, Integer> mapCount2 = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (secret.charAt(i) == guess.charAt(i)){
                rightCount++;
                continue;
            }
            mapCount1.put(secret.charAt(i), mapCount1.getOrDefault(secret.charAt(i), 0)+1);
            mapCount2.put(guess.charAt(i), mapCount2.getOrDefault(guess.charAt(i), 0)+1);
        }
        int posErrorCount = 0;
        if (mapCount1.size() > 0){
            for (Map.Entry<Character, Integer> map:mapCount1.entrySet()){
                char c = map.getKey();
                if (mapCount2.containsKey(c)){
                    posErrorCount += Math.min(map.getValue(), mapCount2.get(c));
                }
            }
        }
        return rightCount + "A" + posErrorCount + "B";
    }

    public static void main(String[] args) {
        GetHint1 getHint1 = new GetHint1();
        System.out.println(getHint1.getHint("1807", "7810"));
        System.out.println(getHint1.getHint("1123", "0111"));
    }
}
