package com.exercise.algorithm.binarySearch;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num/2+1;
        long sq = 0;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            sq = (long) mid * mid;
            if (sq < num){
                left = mid + 1;
            }else if (sq > num){
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare square = new IsPerfectSquare();
        System.out.println(square.isPerfectSquare(808201));
    }
}
