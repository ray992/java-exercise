package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName DominantIndex
 * @Description 至少是其他数字两倍的最大数
 * @Author yeqiang
 * @Date 2022/1/13 上午9:58
 * @Version 1.0
 **/
public class DominantIndex {

    static class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return 0;
        }
        int[] copyNums = new int[n];
        System.arraycopy(nums, 0, copyNums, 0, n);
        Arrays.sort(copyNums);
        int max = copyNums[n-1];
        for (int i = 1; i < n-1; i++){
            if (max < 2*copyNums[i]){
                return -1;
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] == max){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DominantIndex dominantIndex = new DominantIndex();
        //System.out.println(dominantIndex.dominantIndex(new int[]{3,6,1,0}));
        //System.out.println(dominantIndex.dominantIndex(new int[]{1,2,3,4}));
        //System.out.println(dominantIndex.dominantIndex(new int[]{1}));
        System.out.println(dominantIndex.dominantIndex(new int[]{0,0,0,1}));
    }
}
