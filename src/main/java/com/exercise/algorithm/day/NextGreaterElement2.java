package com.exercise.algorithm.day;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName NextGreaterElement2
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/31 下午3:16
 * @Version 1.0
 **/
public class NextGreaterElement2 {

    public Deque<Integer> d1 = new LinkedList<>();
    public Deque<Integer> d2 = new LinkedList<>();

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int n:nums1){
            d1.addLast(n);
        }
        for (int n:nums2){
            d2.addLast(n);
        }
        int i = 1;
        Stack<Integer> saveStack = new Stack<>();
        while (!d1.isEmpty()){
            int target = d1.pollFirst();
            boolean like = false;
            int greaterValue = -1;
            while (!d2.isEmpty()){
                int val = d2.pollFirst();
                saveStack.push(val);
                if (val == target){
                    like = true;
                }
                if (!like){
                    continue;
                }
                if (val > target){
                    greaterValue = val;
                    break;
                }
            }
            while (!saveStack.isEmpty()){
                d2.addFirst(saveStack.pop());
            }
            result[i-1] = greaterValue;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        NextGreaterElement2 nextGreaterElement2 = new NextGreaterElement2();
        int[] result =  nextGreaterElement2.nextGreaterElement(nums1, nums2);
        for (int i:result){
            System.out.print(i);
        }
        System.out.println(result);
    }
}
