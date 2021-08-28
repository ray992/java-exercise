package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Generate
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/8 上午10:22
 * @Version 1.0
 **/
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> numRowsList = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            int j = 0;
            List<Integer> currentRowList = new ArrayList<>();
            while (j <(i+1)){
                int culVal = 0;
                if (j == 0 || j == i){
                    culVal = 1;
                }else {
                    culVal = numRowsList.get(i-1).get(j-1) + numRowsList.get(i-1).get(j);
                }
                currentRowList.add(culVal);
                j++;
            }
            numRowsList.add(currentRowList);
        }
        return numRowsList;
    }

    public List<Integer> getRow(int rowIndex) {
      return null;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(5));
    }
}
