package com.exercise.algorithm;



/**
 * @ClassName OnlyOneTimeNumber
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Author yeqiang
 * @Date 2021/1/17 10:25 下午
 * @Version 1.0
 **/
public class OnlyOneTimeNumber {

    public int singleNumber(int[] nums){
        int c = 0;
        for (int i = 0; i < nums.length ; i++){
            int a = nums[i];
            int compared = 0;
            for (int j = 0 ; j < nums.length ; j ++){
                if (i == j){
                    continue;
                }
                int b = nums[j];
                if (a == b){
                    continue;
                }
                compared ++;
            }
            if (compared == nums.length -1){
                c = a;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,1,2};
        OnlyOneTimeNumber onlyOneTimeNumber = new OnlyOneTimeNumber();
        System.out.println(onlyOneTimeNumber.singleNumber(nums));
    }
}
