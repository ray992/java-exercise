package com.exercise.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MajorityElement
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/1 下午5:48
 * @Version 1.0
 **/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int halfNum = nums.length/2;
        for (int i = 0; i < nums.length; i++){
            if (!countMap.containsKey(nums[i])){
                countMap.put(nums[i], 1);
            }else {
                countMap.put(nums[i], countMap.get(nums[i])+1);
            }
        }
        int majorityElement = 0;
        for (Map.Entry<Integer, Integer> map:countMap.entrySet()){
           int count = map.getValue();
           if (count > halfNum){
               majorityElement = map.getKey();
               break;
           }
        }
        return majorityElement;
    }
    //解法2 排序， 比较相邻元素
    //解法3 set

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3,2,3}));
    }
}
