package com.exercise.algorithm;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/12 10:38 下午
 * @Version 1.0
 **/
public class BinaryTree {

    public static boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split("[,]");
        if (ss.length == 0){
            return false;
        }
        int diff = 1;
        for (String s : ss) {
            diff -= 1;
            if (diff < 0) {
                return false;
            }
            if (!s.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,#,#"));
    }
}
