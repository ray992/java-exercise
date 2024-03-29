package com.exercise.algorithm.day;

/**
 * @ClassName CountBattleships
 * @Description 甲板上的战舰
 * @Author yeqiang
 * @Date 2021/12/18 下午6:17
 * @Version 1.0
 **/
public class CountBattleships {

    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
