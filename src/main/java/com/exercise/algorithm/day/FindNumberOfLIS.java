package com.exercise.algorithm.day;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @ClassName FindNumberOfLIS
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/20 上午10:30
 * @Version 1.0
 **/
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> orderChildSerialMap = new TreeMap(){

            @Override
            public Comparator<Integer> comparator() {
                return new MyComparator();
            }
        };
        for (int i = 0; i < n; i ++){
            int curLength = 1;
            int curElement = nums[i];
            int k = i + 1;
            while (k < n){
                int tempElement = curElement;
                int tempLength = curLength;
                for (int j = k; j < n; j++){
                    if (tempElement > nums[j]){
                        continue;
                    }
                    tempLength++;
                    tempElement = nums[j];
                    if (j == n-1){
                        Integer curCount = orderChildSerialMap.getOrDefault(tempLength, 0);
                        orderChildSerialMap.put(tempLength, curCount+1);
                    }
                }
                k++;
            }
        }
        Iterator<Integer> iterator = orderChildSerialMap.keySet().iterator();
        return orderChildSerialMap.get(iterator.next());
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
