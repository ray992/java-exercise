package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName GiveGem
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 3:02 PM
 * @Version 1.0
 **/
public class GiveGem {

    public int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++){
            int x = operations[i][0];
            int y = operations[i][1];
            int remove = gem[x]/2;
            gem[x] = gem[x] - remove;
            gem[y] = gem[y] + remove;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

    public static void main(String[] args) {
        GiveGem giveGem = new GiveGem();
        System.out.println(giveGem.giveGem(new int[]{3,1,2}, new int[][]{{0,2},{2,1},{2,0}}));
    }
}
