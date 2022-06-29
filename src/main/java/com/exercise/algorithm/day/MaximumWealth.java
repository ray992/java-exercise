package com.exercise.algorithm.day;

/**
 * @ClassName MaximumWealth
 * @Description 最大资产
 * @Author yeqiang
 * @Date 2022/4/14 9:40 AM
 * @Version 1.0
 **/
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++){
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++){
                temp = temp + accounts[i][j];
            }
            if (temp > maxWealth){
                maxWealth  = temp;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        MaximumWealth maximumWealth = new MaximumWealth();
        System.out.println(maximumWealth.maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
    }
}
