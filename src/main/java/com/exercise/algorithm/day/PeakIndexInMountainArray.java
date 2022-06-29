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

    public int peakIndexInMountainArray2(int[] arr) {

        int res = 0;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = (right - left) /2 + left;
            int cur = arr[mid];
            if (mid > 1 && cur < arr[mid -1]){
                right = mid - 1;
            }else if (mid < n-1 && cur < arr[mid + 1]){
                left = mid + 1;
            }else {
                res = mid;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray  peakIndexInMountainArray = new PeakIndexInMountainArray();
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{3,5,3,2,0}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{0, 2,1 , 0}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{18,29,38,59,98,100,99,98,90}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{0,10,5,2}));
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{3,4,5,1}));
        //System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
