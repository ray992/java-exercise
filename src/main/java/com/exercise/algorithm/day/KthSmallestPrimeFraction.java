package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName KthSmallestPrimeFraction
 * @Description 第K个最小素数分数
 * @Author yeqiang
 * @Date 2021/11/29 上午9:31
 * @Version 1.0
 **/
public class KthSmallestPrimeFraction {

    //a/b < c/d ===> a*d < b*c
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        //递增顺序
        Collections.sort(frac, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o2[1] - o1[1]*o2[0];
            }
        });
        return frac.get(k-1);
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction kthSmallestPrimeFraction = new KthSmallestPrimeFraction();
        System.out.println(Arrays.toString(kthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 5)));
    }
}
