package com.exercise.algorithm.day;

/**
 * @ClassName Bit
 * @Description 比特位计数
 * @Author yeqiang
 * @Date 2021/3/3 8:29 下午
 * @Version 1.0
 **/
public class Bit {

    /**
    *  0, 1, 2, 1, 2, 2, 3, 1, 1, 2,  3,  2, 3,  3, 4, 1
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
     *
     **/
    public static int[] countBits(int num){
        int[] count = new int[num+1];
        count[0] = 0;
        for (int i = 0 ; i <= num; i++){
            if (i % 2 == 1){
                count[i] = count[i -1] + 1;
            }else {
                count[i] = count[i/2];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = countBits(100);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+",");
        }
    }
}
