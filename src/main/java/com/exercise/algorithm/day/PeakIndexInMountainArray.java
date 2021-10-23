package com.exercise.algorithm.day;

/**
 * @ClassName PeakIndexInMountainArray
 * @Description 山峰数组的顶部
 * @Author yeqiang
 * @Date 2021/10/14 上午9:49
 * @Version 1.0
 **/
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int pre = -1;
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > pre && arr[i] > arr[i+1] && i > 0){
                res = i;
                break;
            }
            pre = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray  peakIndexInMountainArray = new PeakIndexInMountainArray();
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{0, 1 , 0}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{1,3,5,4,2}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{3,4,5,1}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
