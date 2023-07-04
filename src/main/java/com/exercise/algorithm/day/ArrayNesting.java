package com.exercise.algorithm.day;

import java.util.HashSet;

/**
 * @ClassName ArrayNesting
 * @Description 数组嵌套
 * @Author yeqiang
 * @Date 2022/7/17 10:02 AM
 * @Version 1.0
 **/
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        HashSet<Integer> existHashSet = new HashSet<>();
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int size = 0;
            while (!existHashSet.contains(cur)){
                existHashSet.add(cur);
                size++;
                cur = nums[cur];
            }
            existHashSet.clear();
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }

    public int arrayNesting2(int[] nums) {
        int maxSize = Integer.MIN_VALUE;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            int cnt = 0;
            while (!visited[i]){
                visited[i] = true;
                cnt++;
                i = nums[i];
            }
            maxSize = Math.max(maxSize, cnt);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        System.out.println(arrayNesting.arrayNesting2(new int[]{5,4,0,3,1,6,2}));
    }
}
