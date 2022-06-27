package com.exercise.algorithm.binarySearch;

public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int sum = 0;
        for (int k : arr1) {
            boolean validStatus = true;
            for (int j : arr2) {
                if (Math.abs(k - j) <= d) {
                    validStatus = false;
                    break;
                }
            }
            if (validStatus) {
                sum++;
            }
        }
        return sum;
    }
}
