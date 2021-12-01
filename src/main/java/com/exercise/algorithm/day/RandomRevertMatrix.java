package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName RandomRevertMatrix
 * @Description 随机翻转矩阵
 * @Author yeqiang
 * @Date 2021/11/27 下午5:22
 * @Version 1.0
 **/
public class RandomRevertMatrix {

    Map<Integer, int[]> positionMap =  new HashMap<>();
    List<Integer> recordList = new ArrayList<>();
    List<Integer> backList = new ArrayList<>();
    Random random = new Random();
    int m , n;

    public RandomRevertMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        int t = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                positionMap.put(t, new int[]{i, j});
                recordList.add(t);
                backList.add(t);
                t++;
            }
        }
    }

    public int[] flip() {
        int randomIndex  = random.nextInt(recordList.size());
        int key = recordList.get(randomIndex);
        int[] position = positionMap.get(key);
        recordList.remove(new Integer(key));
        return position;
    }

    public void reset() {
        recordList.clear();
        recordList.addAll(backList);
    }

    public static void main(String[] args) {
        RandomRevertMatrix randomRevertMatrix = new RandomRevertMatrix(3, 1);
        System.out.println(Arrays.toString(randomRevertMatrix.flip()));
        System.out.println(Arrays.toString(randomRevertMatrix.flip()));
        System.out.println(Arrays.toString(randomRevertMatrix.flip()));
        randomRevertMatrix.reset();
        System.out.println(Arrays.toString(randomRevertMatrix.flip()));
    }
}
