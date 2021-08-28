package com.exercise.algorithm.day;

/**
 * @ClassName IpStringToIntNumber
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/18 下午5:54
 * @Version 1.0
 **/
public class IpStringToIntNumber {

    public int transformInt(String ip){
        String[] seg = ip.split("[.]");
        int seg0 = Integer.parseInt(seg[0])<< 24;
        int seg1 = Integer.parseInt(seg[1])<< 16;
        int seg2 = Integer.parseInt(seg[2])<< 8;
        int seg3 = Integer.parseInt(seg[3]);
        return seg0 + seg1 + seg2 + seg3;
    }

    public static void main(String[] args) {
        IpStringToIntNumber ipStringToIntNumber = new IpStringToIntNumber();
        System.out.println(ipStringToIntNumber.transformInt("10.0.3.193"));
    }
}
