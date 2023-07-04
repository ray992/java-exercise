package com.exercise.algorithm.competition.nio;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DecodeMessage
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/3 10:35 AM
 * @Version 1.0
 **/
public class DecodeMessage {

    public String decodeMessage(String key, String message) {
        Map<Character, Character>  map = new HashMap<>();
        char init = 'a';
        for (char c:key.toCharArray()){
            if (c == ' '){
                continue;
            }
            if (map.containsKey(c)){
                continue;
            }
            map.put(c, init);
            init = (char) (init + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:message.toCharArray()){
            stringBuilder.append(map.getOrDefault(c, ' '));
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();
        System.out.println(decodeMessage.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
