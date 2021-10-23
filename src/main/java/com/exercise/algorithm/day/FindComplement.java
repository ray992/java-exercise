package com.exercise.algorithm.day;

/**
 * @ClassName FindComplement
 * @Description 数字的补数
 * @Author yeqiang
 * @Date 2021/10/18 上午9:33
 * @Version 1.0
 **/
public class FindComplement {

    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:binaryString.toCharArray()){
            if (c == '0'){
                stringBuilder.append("1");
            }else if (c == '1'){
                stringBuilder.append("0");
            }
        }
        String complementString = stringBuilder.toString();
        int index = complementString.indexOf("1");
        complementString = (index > 0)?complementString.substring(index):complementString;
        double complement = 0;
        for (int i = complementString.length() - 1; i >= 0; i--){
            if (complementString.charAt(i) == '1'){
                complement+= Math.pow(2, complementString.length() - 1-i);
            }
        }
        return (int)complement;
    }

    public static void main(String[] args) {
        FindComplement findComplement = new FindComplement();
        System.out.println(findComplement.findComplement(1));
    }
}
