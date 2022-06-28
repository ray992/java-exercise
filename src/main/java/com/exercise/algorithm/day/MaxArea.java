package com.exercise.algorithm.day;

/**
 * @ClassName MaxArea
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/5 10:44 下午
 * @Version 1.0
 **/
public class MaxArea {

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }
        int max = 0;
        int actualHeight = 0;
        int actualWidth = 0;
        for(int i = 0; i < height.length; i++){
            int h1 = height[i];
            for (int j = i+1; j < height.length; j++){
                int h2 = height[j];
                if(h1>=h2){
                    actualHeight = h2;
                }else {
                    actualHeight = h1;
                }
                actualWidth = j - i;
                int area = actualHeight*actualWidth;
                if (area > max){
                    max = area;
                }
            }
        }
        return max;
    }

    public static int maxArea2(int[] height){
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j){
            maxArea = height[i] < height[j] ? Math.max(maxArea, (j-i)*height[i++]):Math.max(maxArea, (j-i)*height[j--]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}
