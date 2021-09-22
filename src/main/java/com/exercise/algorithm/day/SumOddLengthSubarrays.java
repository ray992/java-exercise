package com.exercise.algorithm.day;

/**
 * @ClassName SumOddLengthSubarrays
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/29 下午10:43
 * @Version 1.0
 **/
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int childLength = 1;
        int i = 0;
        while (true){
            int j = 0;
            int tempSum = 0;
            if (childLength > n ){
                break;
            }
            boolean isExceedIndex = false;
            int k = i;
            while (j < childLength){
                if (k >= n || k < 0){
                    isExceedIndex = true;
                    childLength = childLength + 2;
                    break;
                }
                tempSum+= arr[k];
                j++;
                k++;
            }
            if (!isExceedIndex){
                sum+=tempSum;
                i = k + 1 - childLength + 1;
            }else {
                i = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOddLengthSubarrays sumOddLengthSubarrays = new SumOddLengthSubarrays();
        System.out.println(sumOddLengthSubarrays.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
