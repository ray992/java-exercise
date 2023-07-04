package com.exercise.algorithm.binarySearch;

/**
 * @ClassName FirstErrorVersion
 * @Description 第一个错误版本
 * @Author yeqiang
 * @Date 2022/7/2 9:47 AM
 * @Version 1.0
 **/
public class FirstErrorVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int middle = (right - left) / 2 + left;
            if (isBadVersion(middle)){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version){
        if (version == 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FirstErrorVersion firstErrorVersion = new FirstErrorVersion();
        System.out.println(firstErrorVersion.firstBadVersion(3));
    }

}
