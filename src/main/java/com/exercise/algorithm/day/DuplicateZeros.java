package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName DuplicateZeros
 * @Description 复写零
 * @Author yeqiang
 * @Date 2022/6/17 10:19 AM
 * @Version 1.0
 **/
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0, j = 0; i < n; i++, j++){
            if (j > n - 1){
                break;
            }
            temp[j] = arr[i];
            if (arr[i] == 0){
                if (j + 1 > n - 1){
                    break;
                }
                temp[++j] = 0;
            }
        }
        System.arraycopy(temp, 0, arr, 0, n);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        duplicateZeros.duplicateZeros(new int[]{1,2,3});
        int a = 3;
        int b = 10;
        System.out.println((a & 1) );
        System.out.println(b& 1);
    }
}
