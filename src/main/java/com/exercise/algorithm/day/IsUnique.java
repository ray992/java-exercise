package com.exercise.algorithm.day;

/**
 * @ClassName IsUnique
 * @Description 判断字符是唯一的
 * @Author yeqiang
 * @Date 2021/9/7 下午9:09
 * @Version 1.0
 **/
public class IsUnique {

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++ ){
            for (int j = i + 1; j < chars.length; j++){
                if (chars[i] == chars[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique("leetcode"));
        System.out.println(isUnique.isUnique("abc"));
        char[] c1 = {'b', 'a', 'c'};
    }
}
