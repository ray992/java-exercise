package com.exercise.algorithm.day;

/**
 * @ClassName MaxProduct
 * @Description 最大单词长度乘积
 * @Author yeqiang
 * @Date 2021/11/17 上午9:38
 * @Version 1.0
 **/
public class MaxProduct {

    public int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (compareCommonCharacter(words[i], words[j])){
                    continue;
                }
                max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }

    public boolean compareCommonCharacter(String s1, String s2){
        for (char c:s1.toCharArray()){
            if (s2.contains(new String(new char[]{c}))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        //System.out.println(maxProduct.compareCommonCharacter("abc", "efa"));
        //System.out.println(maxProduct.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(maxProduct.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(maxProduct.maxProduct(new String[]{"a","aa","aaa","aaaa"}));
        System.out.println(1<<30);
        System.out.println(1<< 0);
    }
}
