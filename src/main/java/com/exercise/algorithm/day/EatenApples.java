package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EatenApples
 * @Description 吃苹果的最大数目
 * @Author yeqiang
 * @Date 2021/12/24 上午10:02
 * @Version 1.0
 **/
public class EatenApples {

    public int eatenApples(int[] apples, int[] days) {
        int sum = 0;
        int spendDay = 1;
        List<int[]> appleList = new ArrayList<>();
        for (int i = 0; i < apples.length; i++){
            int curNum = apples[i];
            int duration = days[i];
            int[] curApps = {spendDay+duration, curNum};
            appleList.add(curApps);
            spendDay++;
        }
        int day = 1;
        for (int[] apps:appleList){
            int duration = apps[0];
            int num = apps[1];
            if (day >= duration && num == 0){
                continue;
            }
            while (duration > day && num > 0){
                sum ++;
                day++;
                num--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        EatenApples eatenApples = new EatenApples();
        //System.out.println(eatenApples.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
        //System.out.println(eatenApples.eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
        System.out.println(eatenApples.eatenApples(new int[]{2,1,10}, new int[]{2,10,1}));
    }
}
