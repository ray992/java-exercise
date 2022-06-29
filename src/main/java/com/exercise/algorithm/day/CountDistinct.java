package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName CountDistinct
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/1 10:52 AM
 * @Version 1.0
 **/
public class CountDistinct {

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++){
            if (nums[i] % p == 0){
                v[i] = true;
            }
        }
        int l = 0, r = 0;
        int t = 0;
        while (r < n){
            if (v[r]){
                t++;
            }
            while (t > k){
                if (v[l]){
                    t--;
                }
                l++;
            }
            for (int i = l; i <= r; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for (int m = i; m <= r; m++){
                    stringBuilder.append(nums[m]).append(",");
                }
                set.add(stringBuilder.toString());
            }
            r++;
        }
        return set.size();
    }

    public static void main(String[] args) {
        CountDistinct countDistinct = new CountDistinct();
        //System.out.println(countDistinct.countDistinct(new int[]{2,3,3,2,2}, 2, 2));
        System.out.println(countDistinct.countDistinct(new int[]{1,9,8,7,19}, 1, 6));
        // 1, 9, 8, 7, 19
        //1, 9, |9, 8 | 8, 7 | 7, 19
        // 1,9,8 | 9,8,7| 8,7,19|
        // 1, 9, 8, 7 | 9 8 7 19
        // 1 9  8 7 19
    }
}
