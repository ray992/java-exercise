package com.exercise.algorithm;

/**
 * @ClassName MaxSubArray
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/4 下午2:29
 * @Version 1.0
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int allNumMax = 0;
        for (int num : nums) {
            allNumMax += num;
        }
        int tempVal = 0;
        int max = allNumMax;
        for (int j = nums.length -1; j >= 0; j--){
           int newAllNumMax = 0;
           tempVal = allNumMax;
           int m = j;
           while (m < (nums.length - 1)){
               tempVal = tempVal - nums[m+1];
               m++;
           }
           for (int i = 0; i < nums.length; i++){
               if (i > j){
                   break;
               }
               int removeVal = 0;
               for (int k = 0; k < i; k++){
                   removeVal+=nums[k];
               }
               newAllNumMax = tempVal - removeVal;
               if (max < newAllNumMax){
                   max = newAllNumMax;
               }
           }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-1,-2}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2,1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
