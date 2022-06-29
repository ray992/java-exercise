package com.exercise.algorithm.day;

/**
 * @ClassName FindMaxCI
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/19 10:16 PM
 * @Version 1.0
 **/
public class FindMaxCI {

    public int findMaxCI(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int res = 0;
        int i = 0;
        while (i < n - 1){
            int cnt = 1;
            int pre = nums[i];
            boolean intercept = false;
            int j = i + 1;
            for (; j < n; j++){
                if (nums[j] > pre){
                    cnt++;
                    pre = nums[j];
                }else {
                    intercept = true;
                    break;
                }
            }
            res = Math.max(res, cnt);
            if (!intercept){
                i = j + 1;
            }else {
                i = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMaxCI findMaxCI = new FindMaxCI();
        System.out.println(findMaxCI.findMaxCI(new int[]{54,42,62,75,82,86,86}));
        System.out.println(findMaxCI.findMaxCI(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57}));
    }
}
