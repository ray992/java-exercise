package com.exercise.algorithm.competition.nio;

import com.exercise.algorithm.listNode.ListNode;

import java.util.Arrays;

/**
 * @ClassName SpiralMatrix
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/3 10:44 AM
 * @Version 1.0
 **/
public class SpiralMatrix {

    int[][] mat = null;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        mat = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(mat[i], -1);
        }
        circle(0, 0, m -1, n -1, head);
        System.out.println(Arrays.deepToString(mat));
        return mat;
    }

    // 遍历 以 (x1, y1) 作为左上角，(x2, y2) 作为右下角形成的「圈」
    void circle(int x1, int y1, int x2, int y2, ListNode head) {
        if (x2 < x1 || y2 < y1){
            return;
        }

        // 只有一行时，按「行」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++){
                if (head == null){
                    break;
                }
                mat[x1][i] = head.val;
                head = head.next;
            }
            return;
        }
        // 只有一列时，按「列」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++){
                if (head == null){
                    break;
                }
                mat[i][y1] =  head.val;
                head = head.next;
            }
            return;
        }

        // 遍历当前「圈」
        for (int i = y1; i < y2; i++){
            if (head == null){
                break;
            }
            mat[x1][i] = head.val;
            head = head.next;
        }
        for (int i = x1; i < x2; i++){
            if (head == null){
                break;
            }
            mat[i][y2] =  head.val;
            head = head.next;
        }
        for (int i = y2; i > y1; i--){
            if (head == null){
                break;
            }
            mat[x2][i] = head.val;
            head = head.next;
        }
        for (int i = x2; i > x1; i--){
            if (head == null){
                break;
            }
            mat[i][y1] =  head.val;
            head = head.next;
        }

        // 往里收一圈，继续遍历
        circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1, head);
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

    }
}
