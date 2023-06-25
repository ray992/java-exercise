package com.exercise.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShortUrlGeneratorUtil {

    private static final String salt = "abc";

    public static String buildSalt(){
        return UUID.randomUUID().toString();
    }


    // 62位
    private static final String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,

            "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,

            "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,

            "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,

            "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,

            "U" , "V" , "W" , "X" , "Y" , "Z"

    };


    public static String buildShortUrl(String url){
        // 对传入的长链接进行Md5加密
        String md5String = Md5Encoder.encode(buildSalt() + url);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            StringBuilder stringBuilder = new StringBuilder();
            // 把加密字符按照8位一组， 16进制与 0x3FFFFFFF 进行位与运算
            int startIndex = i * 8;
            int endIndex = startIndex + 8;
            String subString = md5String.substring(startIndex, endIndex);
            //
            long hexSubLong = Long.parseLong(subString, 16);
            long hexLongVal = 0x3FFFFFFF & hexSubLong; //截取前面30位数
            for (int j = 0; j < 6; j++){
                // 取得字符数组索引
                int index = (int) (0x0000003D & hexLongVal); //最大索引值61， 取得字符索引
                // 取得的字符进行拼接
                stringBuilder.append(chars[index]);
                // 每次循环按位右移5位
                hexLongVal = hexLongVal >> 5;
            }
            resultList.add(stringBuilder.toString());
        }
        System.out.println(resultList);
        return resultList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(buildShortUrl("https://0xjiaming-dev.rarefy.vip/#/pages/register/index?inviteCode=DV67M7E"));
        System.out.println(Long.toBinaryString(0xf98f6bcd));
        //001001100011110110101111001101
        //111111111111111111111111111111
        //1111111111111111111111111111111111111001100011110110101111001101
        System.out.println("111111111111111111111111111111".length());
    }
}
