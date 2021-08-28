package com.exercise.algorithm;

import java.util.Arrays;

/**
 * @ClassName TriangleNumber
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/4 上午9:12
 * @Version 1.0
 **/
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i ++){
            int a = nums[i];
            for (int j = i+1; j < nums.length; j++){
                int b = nums[j];
                for (int k = j+1; k < nums.length; k++){
                    if (i == j || i == k || k == j){
                        continue;
                    }
                    int c = nums[k];
                    if (((a > Math.abs((b -c))) && (a < (b+c)))){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    //双指针法
    public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        int number = triangleNumber.triangleNumber(new int[]{2,2,3,4,2,4,1,4,6,8,1,23,3});
        System.out.println(number);
    }
}
