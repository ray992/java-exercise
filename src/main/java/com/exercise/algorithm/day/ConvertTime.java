package com.exercise.algorithm.day;

/**
 * @ClassName ConvertTime
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/3 10:37 AM
 * @Version 1.0
 **/
public class ConvertTime {

    public int convertTime(String current, String correct) {
        String[] t1 = current.split("[:]");
        Integer h1 = Integer.parseInt(t1[0]);
        Integer m1 = Integer.parseInt(t1[1]);
        String[] t2 = correct.split("[:]");
        Integer h2 = Integer.parseInt(t2[0]);
        Integer m2 = Integer.parseInt(t2[1]);
        int diff = (h2 - h1)*60 + (m2 - m1);
        int n = 0;
        while (diff != 0){
            if (diff >= 60){
                diff = diff - 60;
            }else if (diff >= 15){
                diff = diff - 15;
            }else if (diff >= 5){
                diff = diff - 5;
            }else {
                diff = diff -1;
            }
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        ConvertTime convertTime = new ConvertTime();
        //System.out.println(convertTime.convertTime("02:30", "04:35"));
        //System.out.println(convertTime.convertTime("00:01", "23:00"));
        System.out.println(convertTime.convertTime("01:42", "02:42"));
    }
}
