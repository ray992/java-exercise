package com.exercise.algorithm.day;

/**
 * @ClassName CheckRecord
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/17 上午8:39
 * @Version 1.0
 **/
public class CheckRecord {

    public boolean checkRecord(String s) {
        boolean absent = false, late = false;
        char[] chars = s.toCharArray();
        int crossLate = 0, sumAbsent = 0;
        char preChar = '\0';
        for (char c:chars){
            if (c == 'A'){
                sumAbsent++;
            }else if (c == 'L' && !late){
                if (preChar == 'L'){
                    crossLate++;
                    if (crossLate >= 3){
                        late = true;
                    }
                }else {
                    crossLate = 1;
                }
            }
            preChar = c;
        }
        if (sumAbsent >= 2){
            absent = true;
        }
        return !absent && !late;
    }

    public static void main(String[] args) {
        CheckRecord checkRecord = new CheckRecord();
        System.out.println(checkRecord.checkRecord("PPALLP"));
        System.out.println(checkRecord.checkRecord("PPALLL"));
        System.out.println(checkRecord.checkRecord("LALL"));
    }
}
