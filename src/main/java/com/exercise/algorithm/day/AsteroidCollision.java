package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName AsteroidCollision
 * @Description 行星碰撞
 * @Author yeqiang
 * @Date 2022/7/13 8:17 AM
 * @Version 1.0
 **/
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            int curAsteroid = asteroids[i];
            if (stack.empty()){
                stack.add(curAsteroid);
            }else {
                while (!stack.empty()){
                    if ((stack.peek() > 0 && curAsteroid > 0) || (stack.peek() < 0 && curAsteroid < 0) || (stack.peek() < 0 && curAsteroid > 0)){
                        stack.add(curAsteroid);
                        break;
                    }
                    int p1 = Math.abs(stack.peek());
                    int p2 = Math.abs(curAsteroid);
                    if (p1 > p2){
                        break;
                    }else if (p1 == p2){
                        stack.pop();
                        break;
                    }else {
                        stack.pop();
                        if (stack.empty()){
                            stack.add(curAsteroid);
                            break;
                        }
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()){
            res[i] = stack.pop();
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        //System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{5, 10, -5})));
        //System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{8,-8})));
        //System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{10,2,-5})));
        //System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(new int[]{1, -2, -2, -2})));
    }
}
