package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TitleToNumber
 * @Description excel表列序号
 * @Author yeqiang
 * @Date 2021/7/30 上午9:09
 * @Version 1.0
 **/
public class TitleToNumber {

    public static char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                                       'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                                        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.equals("")){
            return 0;
        }
        Map<Character, Integer> columnMap = new HashMap<>();
        int startValue = 1;
        for (char c:characters){
            columnMap.put(c, startValue);
            startValue++;
        }
        char[] chars = columnTitle.toCharArray();
        int length = chars.length;
        int number = 0;
        int index = 0;
        for (char c:chars){
            if (index == chars.length - 1){
                number+=columnMap.get(c);
            }else {
                //number += 26*(length-1)*columnMap.get(c);
                number += Math.pow(26, (length-1))*columnMap.get(c);
            }
            index++;
            length--;
        }
        return number;
    }

    public static void main(String[] args) {
        //System.out.println(titleToNumber(("A")));
        //System.out.println(titleToNumber(("AB")));
        //System.out.println(titleToNumber(("ZZY")));
        //System.out.println(titleToNumber("FXSHRXW"));
        //System.out.println('B'-'Z');
    }
}
