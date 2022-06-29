package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName FullBloomFlowers
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/24 4:28 PM
 * @Version 1.0
 **/
public class FullBloomFlowers {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int fn = flowers.length;
        int[] nums = new int[1000];
        for (int i = 0; i < fn; i++){
            nums[flowers[i][0]] +=1;
            nums[flowers[i][1]+1] -=1;
        }
        for (int i = 1; i < 1000; i++){
            nums[i] += nums[i - 1];
        }
        int pn = persons.length;
        int[] ans = new int[pn];
        for (int i = 0; i < pn; i++){
            ans[i] = nums[persons[i]];
        }
        return ans;
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] persons){
        int fn = flowers.length;
        int[] start = new int[fn];
        int[] end = new int[fn];
        for (int i = 0; i < fn; i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int pn = persons.length;
        int[] ans = new int[pn];
        for (int i = 0; i < pn; i++){
            ans[i] += Arrays.binarySearch(start, persons[i]+1) - Arrays.binarySearch(end,  persons[i]);
        }
        return ans;
    }

    public int[] fullBloomFlowers3(int[][] flowers, int[] persons) {
        List<Integer> in = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for(int[] f : flowers){
            in.add(f[0]);
            out.add(f[1]+1);
        }
        Collections.sort(in);
        Collections.sort(out);
        int[][] t = new int[persons.length][2];
        for(int i = 0 ; i < persons.length ; i++){
            t[i][0] = persons[i];
            t[i][1] = i;
        }
        Arrays.sort(t, (a , b)->(a[0]- b[0]));
        int idx1 = 0 , idx2 = 0;
        int[] ret = new int[persons.length];
        int cur = 0;
        for(int i = 0 ; i < t.length ; i++){
            while(idx1 < in.size() && in.get(idx1) <= t[i][0]){
                cur += 1;
                idx1++;
            }
            while(idx2 < out.size() && out.get(idx2) <= t[i][0]){
                cur -= 1;
                idx2++;
            }
            ret[t[i][1]] = cur;
        }
        return ret;
    }


    public static void main(String[] args) {
        FullBloomFlowers fullBloomFlowers = new FullBloomFlowers();
        //System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers2(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11})));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers3(new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})));
    }
}
