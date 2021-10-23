package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReverseBits
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/10 下午9:14
 * @Version 1.0
 **/
public class ReverseBits {

    public int reverseBits(int num) {
        String binString = Integer.toBinaryString(num);
        int oneCount = 0;
        List<Integer> sectionList = new ArrayList<>();
        for (char c:binString.toCharArray()){
            if (c == '0') {
                sectionList.add(oneCount);
                oneCount = 0;
            }else if (c == '1'){
                oneCount++;
            }
        }
        sectionList.add(oneCount);
        int maxLength = 0;
        for (int i = 0; i < sectionList.size(); i++){
            if (i == sectionList.size() - 1){
                break;
            }
            int i1 = sectionList.get(i) + sectionList.get(i+1);
            if (i1 > maxLength){
                maxLength = i1;
            }
        }
        return maxLength+1;
    }

    public int reverseBits2(int num) {
        String s = Integer.toBinaryString(num);
        String[] arr = s.split("0");
        if(arr.length<1) {
            return arr.length+1;
        }
        int max = arr[0].length();
        int res = max+1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].length() + arr[i].length() > max) {
                max = arr[i - 1].length() + arr[i].length();
                res = max + 1;
            }
        }
        return Math.min(res,32);
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits2(1775));
        System.out.println(reverseBits.reverseBits2(7));
        System.out.println(reverseBits.reverseBits2(1));
        System.out.println(reverseBits.reverseBits2(-1));
        System.out.println(reverseBits.reverseBits2(-2));
        System.out.println(12>>>2);
    }
}
