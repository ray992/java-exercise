package com.exercise.algorithm.day;

/**
 * @ClassName CountSegments
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/7 上午9:21
 * @Version 1.0
 **/
public class CountSegments {

    public int countSegments(String s) {
        String[] segs = s.split("[ ]");
        int count = 0;
        for (String ss: segs){
            if (!ss.equals("")){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSegments countSegments = new CountSegments();
        System.out.println(countSegments.countSegments(""));
        System.out.println(countSegments.countSegments("Hello, my name is John"));
        System.out.println(countSegments.countSegments(", , , ,        a, eaefa"));
    }
}
