package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>  resultList = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m ; i++){
            int i1 = l[i];
            int i2 = r[i];
            List<Integer> subList = new ArrayList<>();
            for (int j = i1; j <= i2; j++ ){
                subList.add(nums[j]);
            }
            Collections.sort(subList);
            boolean status = true;
            int diff = subList.get(1) - subList.get(0);
            for (int t = 2; t < subList.size(); t++){
                if (diff != subList.get(t) - subList.get(t -1)){
                    status = false;
                    break;
                }
            }
            resultList.add(status);
        }
        return resultList;
    }

    public static void main(String[] args) {
        CheckArithmeticSubarrays checkArithmeticSubarrays = new CheckArithmeticSubarrays();
        System.out.println(checkArithmeticSubarrays.checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}));
    }
}
