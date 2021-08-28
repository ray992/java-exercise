package com.exercise.algorithm.day;

/**
 * @ClassName ReverseStr
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/20 上午9:37
 * @Version 1.0
 **/
public class ReverseStr {

    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n < k){
            return new StringBuilder(s).reverse().toString();
        }
        if (n >= k && n < 2*k){
            return new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
        }
        int startPosition = 0;
        int lastPosition = 2*k-1;
        StringBuilder result = new StringBuilder();
        while (startPosition < n  || lastPosition < n){
            result.append(new StringBuilder(s.substring(startPosition, Math.min((lastPosition - k + 1), n))).reverse()).append(s, (lastPosition - k + 1), Math.min(lastPosition + 1, n));
            int rest = (n-1) - lastPosition;
            if (rest > 0 &&  rest < k){
                result.append(new StringBuilder(s.substring(lastPosition+1)).reverse());
                break;
            }
            startPosition+=2*k;
            lastPosition+=2*k;
       }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        //System.out.println(reverseStr.reverseStr("abcdefg", 1));
        //System.out.println(reverseStr.reverseStr("abcd", 2));
        //System.out.println(reverseStr.reverseStr("424weddf,",3));
        System.out.println(reverseStr.reverseStr("abcdefg",3));
    }
}
