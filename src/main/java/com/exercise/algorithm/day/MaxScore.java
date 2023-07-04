package com.exercise.algorithm.day;

/**
 * @ClassName MaxScore
 * @Description 分割字符串最大得分
 * @Author yeqiang
 * @Date 2022/8/14 16:14
 * @Version 1.0
 **/
public class MaxScore {

    public int maxScore(String s) {
        int n = s.length();
        int score = Integer.MIN_VALUE;
        for (int i = 1; i < n; i ++){
            int tempScore = 0;
            for (int j = 0; j < i; j++){
                if (s.charAt(j) == '0'){
                    tempScore++;
                }
            }
            for (int k = i; k < n; k++){
                if (s.charAt(k) == '1'){
                    tempScore ++;
                }
            }
            score = Math.max(score, tempScore);
        }
        return score;
    }

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore("011101"));
        System.out.println(maxScore.maxScore("00111"));
        System.out.println(maxScore.maxScore("1111"));
    }
}
