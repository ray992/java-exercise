package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName GetHint
 * @Description 猜数字游戏
 * @Author yeqiang
 * @Date 2021/11/8 上午9:26
 * @Version 1.0
 **/
public class GetHint {

    public String getHint(String secret, String guess) {
        List<Character> firstNotMatchNumberList = new ArrayList<>();
        Deque<Integer> notMatchPositionDeque = new LinkedList<>();
        int n = secret.length();
        int aCount = 0;
        for (int i = 0; i < n; i++){
            if (secret.charAt(i) == guess.charAt(i)){
                aCount++;
            }else {
                firstNotMatchNumberList.add(guess.charAt(i));
                notMatchPositionDeque.addLast(i);
            }
        }
        if (notMatchPositionDeque.size() == 0){
            return aCount+"A0B";
        }
        int bCount = 0;
        while (!notMatchPositionDeque.isEmpty()){
            int position = notMatchPositionDeque.pollFirst();
            if (firstNotMatchNumberList.contains(secret.charAt(position))){
                bCount++;
                firstNotMatchNumberList.remove(new Character(secret.charAt(position)));
            }
        }
        return  aCount+"A" + bCount+"B";
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("1807", "7810"));
        System.out.println(getHint.getHint("1123", "0111"));
        System.out.println(getHint.getHint("1", "0"));
        System.out.println(getHint.getHint("1", "1"));
        System.out.println('9' - 'A');
    }
}
