package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的正方形
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] squareArray = new int[4][2];
        squareArray[0] = new int[]{p1[0], p1[1]};
        squareArray[1] = new int[]{p2[0], p2[1]};
        squareArray[2] = new int[]{p3[0], p3[1]};
        squareArray[3] = new int[]{p4[0], p4[1]};
        Arrays.sort(squareArray, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        //p1 p2
        int l1 = (squareArray[0][0] - squareArray[1][0]) * (squareArray[0][0] - squareArray[1][0]) + (squareArray[0][1] - squareArray[1][1]) * (squareArray[0][1] - squareArray[1][1]);
        //p2 p4
        int l2 = (squareArray[1][0] - squareArray[3][0]) * (squareArray[1][0] - squareArray[3][0]) + (squareArray[1][1] - squareArray[3][1]) * (squareArray[1][1] - squareArray[3][1]);
        //p3 p4
        int l3 = (squareArray[3][0] - squareArray[2][0]) * (squareArray[3][0] - squareArray[2][0]) + (squareArray[3][1] - squareArray[2][1]) * (squareArray[3][1] - squareArray[2][1]);
        //p1 p3
        int l4 = (squareArray[2][0] - squareArray[0][0]) * (squareArray[2][0] - squareArray[0][0]) + (squareArray[2][1] - squareArray[0][1]) * (squareArray[2][1] - squareArray[0][1]);
        //对角线
        int f1 = (squareArray[0][0] - squareArray[3][0]) * (squareArray[0][0] - squareArray[3][0]) + (squareArray[0][1] - squareArray[3][1]) * (squareArray[0][1] - squareArray[3][1]);
        int f2 = (squareArray[1][0] - squareArray[2][0]) * (squareArray[1][0] - squareArray[2][0]) + (squareArray[1][1] - squareArray[2][1]) * (squareArray[1][1] - squareArray[2][1]);
        return l1 != 0 && (l2 == l3) && (l3 == l4) && (l4 == l1) && (f1 == f2);
    }

    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();
        System.out.println(validSquare.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(validSquare.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 12}));
        System.out.println(validSquare.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));
        System.out.println(validSquare.validSquare(new int[]{1, 1}, new int[]{5, 3}, new int[]{3, 5}, new int[]{7, 7}));
    }
}
