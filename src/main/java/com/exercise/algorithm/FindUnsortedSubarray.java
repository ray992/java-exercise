package com.exercise.algorithm;

import java.util.Arrays;

/**
 * @ClassName FindUnsortedSubarray
 * @Description 最短无序连续子数组
 * @Author yeqiang
 * @Date 2021/8/3 上午9:12
 * @Version 1.0
 **/
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 0;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0,  temp, 0 , nums.length);
        Arrays.sort(temp);
        int i = 0 , j = temp.length - 1;
        while (true){
            if ((nums[i] != temp[i])&&(nums[j] != temp[j])){
                break;
            }
            if (nums[i] == temp[i]){
                i++;
            }
            if (nums[j] == temp[j]){
                j--;
            }
            if (i >= j){
                break;
            }
        }
        return (j == i) ? 0 :(j - i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        //int[] nums = {1,2,3,4};
        //int[] nums = {1,2,3,3,3};
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
    }
}
