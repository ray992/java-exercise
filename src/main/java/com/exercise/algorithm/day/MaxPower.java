package com.exercise.algorithm.day;

/**
 * @ClassName MaxPower
 * @Description 连续字符
 * @Author yeqiang
 * @Date 2021/12/1 上午9:53
 * @Version 1.0
 **/
public class MaxPower {

    public int maxPower(String s) {
        int n = s.length();
        if (n == 1){
            return 1;
        }
        int max = 1;
        int count = 1;
        char preChar = s.charAt(0);
        for (int i = 1; i < n; i++){
            if (s.charAt(i) == preChar){
                count++;
                continue;
            }
            if (count > max){
                max = count;
            }
            preChar = s.charAt(i);
            count = 1;
        }
        if (count > max){
            max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();
        System.out.println(maxPower.maxPower("leetcode"));
        System.out.println(maxPower.maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower.maxPower("triplepillooooow"));
        System.out.println(maxPower.maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower.maxPower("tourist"));
        System.out.println(maxPower.maxPower("cc"));
        System.out.println(maxPower.maxPower("ccbccbb"));
    }
}
