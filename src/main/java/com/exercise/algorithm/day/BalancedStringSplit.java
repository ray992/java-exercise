package com.exercise.algorithm.day;

/**
 * @ClassName BalancedStringSplit
 * @Description 分割平衡字符串
 * @Author yeqiang
 * @Date 2021/9/7 上午9:20
 * @Version 1.0
 **/
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
       char[] chars = s.toCharArray();
       int Ln = 0;
       int Rn = 0;
       int answer = 0;
       for (int i = 0; i < chars.length; i++){
           if (chars[i] == 'L'){
               Ln++;
           }
           if (chars[i] == 'R'){
               Rn++;
           }
           if (Ln == Rn){
               answer++;
               Ln = 0;
               Rn = 0;
           }
       }
       return answer;
    }

    public static void main(String[] args) {
        BalancedStringSplit balancedStringSplit = new BalancedStringSplit();
        System.out.println(balancedStringSplit.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit.balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit.balancedStringSplit("RLRRRLLRLL"));
    }
}
