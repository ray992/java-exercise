package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName GetRow
 * @Description 杨辉三角
 * @Author yeqiang
 * @Date 2021/10/8 下午8:46
 * @Version 1.0
 **/
public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        int[][] nums = new int[34][34];
        nums[0][0] = 1;
        nums[1][0] = 1;
        nums[1][1] = 1;
        for (int i = 2; i <= rowIndex; i++){
            for (int j = 0; j <= rowIndex; j++){
                if (j == 0 || j == rowIndex){
                    nums[i][j] = 1;
                }else {
                    nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
                }
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int t = 0; t < nums[rowIndex].length; t++){
            if (nums[rowIndex][t] == 0){
                break;
            }
            resultList.add(nums[rowIndex][t]);
        }
        return resultList;
    }

    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        System.out.println(getRow.getRow(0));
        System.out.println(getRow.getRow(1));
        System.out.println(getRow.getRow(3));
        System.out.println(getRow.getRow(4));
        System.out.println(getRow.getRow(33));
    }
}
