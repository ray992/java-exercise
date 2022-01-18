package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName IsNStraightHand
 * @Description 一手顺子
 * @Author yeqiang
 * @Date 2021/12/30 上午10:01
 * @Version 1.0
 **/
public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        List<Integer> handList = new ArrayList<>();
        Map<Integer, Integer> handCountMap = new HashMap<>();
        for (int h:hand){
            if (!handList.contains(h)){
                handList.add(h);
            }
            handCountMap.put(h, handCountMap.getOrDefault(h, 0)+1);
        }
        while (handList.size() > 0){
            int curElement = handList.get(0);
            handCountMap.put(curElement, handCountMap.get(curElement) -1);
            if (handCountMap.get(curElement) == 0){
                handList.remove(new Integer(curElement));
            }
            for (int i = 1; i < groupSize; i++){
                curElement++;
                if (!handCountMap.containsKey(curElement)){
                    return false;
                }
                handCountMap.put(curElement, handCountMap.get(curElement) -1);
                if (handCountMap.get(curElement) == 0){
                    handList.remove(new Integer(curElement));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsNStraightHand isNStraightHand = new IsNStraightHand();
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand.isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }
}
