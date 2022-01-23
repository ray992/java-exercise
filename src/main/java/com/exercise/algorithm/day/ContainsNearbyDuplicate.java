package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName ContainsNearbyDuplicate
 * @Description 　存在重复元素
 * @Author yeqiang
 * @Date 2022/1/19 上午9:46
 * @Version 1.0
 **/
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length; i++){
            for (int j = i+1; j < length ; j++){
                if (nums[i] == nums[j] && (j - i) <= k){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, PriorityQueue<Integer>> positionMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
           if (!positionMap.containsKey(nums[i])){
               PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
               priorityQueue.offer(i);
               positionMap.put(nums[i], priorityQueue);
           }else {
               positionMap.get(nums[i]).offer(i);
           }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> map:positionMap.entrySet()){
            PriorityQueue<Integer> priorityQueue = map.getValue();
            if (priorityQueue.size() > 1){
                int start = priorityQueue.poll();
                while (!priorityQueue.isEmpty()){
                    int cur = priorityQueue.poll();
                    if ((cur - start) <= k){
                        return true;
                    }
                    start = cur;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate2(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate2(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate2(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate2(new int[]{99, 99}, 2));
    }
}
