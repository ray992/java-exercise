package com.exercise.algorithm.day;

/**
 * @ClassName CountAndSay
 * @Description 外观数列
 * @Author yeqiang
 * @Date 2021/10/15 下午1:34
 * @Version 1.0
 **/
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        if (n == 2){
            return "11";
        }
        String pre = "11";
        for (int i = 3; i <= n; i++){
            char start = pre.charAt(0);
            int count = 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < pre.length(); j++){
                if (pre.charAt(j) == start){
                    count++;
                    continue;
                }
                stringBuilder.append(count).append(start);
                start = pre.charAt(j);
                count = 1;
            }
            stringBuilder.append(count).append(start);
            pre = stringBuilder.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        //System.out.println(countAndSay.countAndSay(1));
        //System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
    }
}
