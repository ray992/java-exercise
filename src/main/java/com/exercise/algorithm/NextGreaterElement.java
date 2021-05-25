package com.exercise.algorithm;

/**
 * @ClassName NextGreaterElement
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/6 8:21 下午
 * @Version 1.0
 **/
public class NextGreaterElement {

    public static int[] solution(int[] nums){
        int[] nextElement = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int j = i+1;
            while (true){
                if (j >= nums.length - 1){
                    j = 0;
                }
                if (j == i){
                    nextElement[i] = -1;
                    break;
                }
                if (nums[j] > temp){
                   nextElement[i] = nums[j];
                   break;
               }
               j++;
            }
        }
        return nextElement;
    }

    public static int[] solution2(int[] nums){
        int[] nextElement = new int[nums.length];
        int[] newNums = new int[nums.length + nums.length];
        for (int i = 0; i < nums.length; i++){
            newNums[i] = nums[i];
        }
        int half = newNums.length/2;
        for (int i = 0; i < nums.length; i++){
            newNums[half+i] = nums[i];
        }
        for (int i = 0; i < nums.length; i ++){
            int temp = newNums[i];
            boolean isHit = false;
            for (int j = i+1; j < nums.length+i; j++){
                if (newNums[j] > temp){
                    nextElement[i] = newNums[j];
                    isHit = true;
                    break;
                }
            }
            if (!isHit){
                nextElement[i] = -1;
            }
        }
        return nextElement;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] next = solution2(nums);
        for (int i = 0; i < next.length; i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
        int i = 2;
        int j = 3;
        System.out.println(i%j);
    }
}
