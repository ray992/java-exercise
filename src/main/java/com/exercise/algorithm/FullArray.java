package com.exercise.algorithm;

/**
 * @ClassName FullArray
 * @Description 全排列
 * @Author yeqiang
 * @Date 2021/12/13 下午9:14
 * @Version 1.0
 **/
public class FullArray {

    public void dfs(int total , int index, String s){
        if (index == total){
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= total; i++){
            dfs(total, index+1, s+i);
        }
    }

    public static void main(String[] args) {
        FullArray fullArray = new FullArray();
        fullArray.dfs(4, 0, "");
    }
}
