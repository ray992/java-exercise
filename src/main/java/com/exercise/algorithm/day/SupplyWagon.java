package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName SupplyWagon
 * @Description TODO
 * @Author yeqiang
 * @Date 2023/4/22 15:03
 * @Version 1.0
 **/
public class SupplyWagon {

    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        if (n == 2){
            return new int[]{supplies[0] + supplies[1]};
        }
        int n1 = n / 2;
        int[] res = new int[n1];
        int temp = n;
        while (temp > n1){
            int min = 0;
            int tag = 0;
            int curIndex = 0;
            for (int p = 0; p < n; p++){
                if (supplies[p] == 0){
                    continue;
                }
                min += supplies[p];
                tag++;
                if (tag == 2){
                    curIndex = p;
                    break;
                }
            }
            int pre = supplies[curIndex];
            int index = curIndex;
            for (int i = index + 1; i < n; i++){
                if (supplies[i] == 0){
                    continue;
                }
                int cur = supplies[i] + pre;
                pre = supplies[i];
                if (cur < min){
                    min = cur;
                    index = i;
                }
            }
            for (int r = index - 1; r >=0; r--){
                if (supplies[r] != 0){
                    supplies[r] = min;
                    break;
                }
            }
            supplies[index] = 0;
            temp--;
        }
        int j = 0;
        for (int i = 0; i < n; i++){
            if (supplies[i] != 0){
                res[j++] = supplies[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SupplyWagon supplyWagon = new SupplyWagon();
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(new int[]{7, 3, 6, 1, 8})));
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(new int[]{1,3,1,5})));
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(new int[]{1,3,1})));
        System.out.println(Arrays.toString(supplyWagon.supplyWagon(new int[]{2,2,3,1})));
    }
}
