package com.exercise.algorithm.day;

/**
 * @ClassName CompareVersion
 * @Description 比较版本号
 * @Author yeqiang
 * @Date 2021/9/1 下午9:36
 * @Version 1.0
 **/
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("[.]");
        String[] s2 = version2.split("[.]");
        int l1 = s1.length;
        int l2 = s2.length;
        int i = 0;
        int result = 0;
        while (i < l1 || i < l2){
            String x1 = "0";
            String x2 = "0";
            if (i < l1){
                x1 = s1[i];
                x1 = formatNumber(x1);
            }
            int v1 = Integer.parseInt(x1);
            if (i < l2){
                x2 = s2[i];
                x2 = formatNumber(x2);
            }
            int v2 = Integer.parseInt(x2);
            if (v1 > v2){
                result = 1;
                break;
            }else if (v1 < v2){
                result =  -1;
                break;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("1.01", "1.001"));
        System.out.println(compareVersion.compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion.compareVersion("0.1", "1.1"));
        System.out.println(compareVersion.compareVersion("1.0.1", "1"));
        System.out.println(compareVersion.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(Integer.parseInt("001"));
        System.out.println(Integer.parseInt("010"));
    }

    public String formatNumber(String s){
        int endIndex = 0;
        char[] chars =  s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != '0'){
                endIndex = i;
                break;
            }
        }
        return s.substring(endIndex);
    }
}
