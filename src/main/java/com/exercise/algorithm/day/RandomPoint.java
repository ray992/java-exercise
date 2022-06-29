package com.exercise.algorithm.day;

import java.util.Random;

/**
 * @ClassName RandomPoint
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/5 10:30 AM
 * @Version 1.0
 **/
public class RandomPoint {

    Random random = null;
    double xc;
    double yc;
    double r;

    public RandomPoint(double radius, double x_center, double y_center) {
       random = new Random();
       xc = x_center;
       yc = y_center;
       r = radius;
    }

    public double[] randPoint() {
        while (true){
            double x = random.nextDouble()*(2*r) - r;
            double y = random.nextDouble()*(2*r) - r;
            if (x * x + y *y <= r * r){
                return new double[]{xc + x, yc + y};
            }
        }
    }
}
