package com.exercise.algorithm;

/**
 * @ClassName ChargeType
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/29 上午11:24
 * @Version 1.0
 **/
public class ChargeType {

    public static void main(String[] args) {
        for (int i = 0; i <= 1; i++){
            for (int j = 0; j <= 1; j++){
                for (int k = 0; k <= 1; k++){
                    for (int l = 0; l <= 1; l++){
                        System.out.println("i="+(i<<3) + " j="+(j<<2)+" k="+(k<<1)+" l="+(l) +" type="+i+j+k+l+" sum="+((i<<3)+(j<<2)+(k<<1)+l));
                    }
                }
            }
        }
    }
}
