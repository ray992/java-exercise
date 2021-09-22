package com.exercise.algorithm.day;

/**
 * @ClassName FindPeakElement
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/15 上午9:56
 * @Version 1.0
 **/
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int answerIndex = 0;
        int start = 0;
        int end = n-1;
        while (start <= end){
            int mid = (end + start)/2;
            int midCur = nums[mid];
            if (((mid-1) >= 0) && midCur < nums[mid-1]){
                end = mid-1;
                continue;
            }
            if (((mid+1) < n) && midCur < nums[mid+1]){
                start = mid+1;
                continue;
            }
            answerIndex = mid;
            break;
        }
        return answerIndex;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        //System.out.println(findPeakElement.findPeakElement(new int[]{1,2,3,1}));
        //System.out.println(findPeakElement.findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement.findPeakElement(new int[]{6,5,4,3,2,3,2}));
    }


}
