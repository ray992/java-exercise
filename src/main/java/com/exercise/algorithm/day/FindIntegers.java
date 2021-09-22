package com.exercise.algorithm.day;

/**
 * @ClassName FindIntegers
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/11 下午11:27
 * @Version 1.0
 **/
public class FindIntegers {

    public int findIntegers(int n) {
      int count = 0;
      for (int i = 0; i <= n; i++){
          String binaryString = Integer.toBinaryString(i);
          if (!binaryString.contains("11")){
              count++;
          }
      }
      return count;
    }

    public static void main(String[] args) {
        FindIntegers findIntegers = new FindIntegers();
        System.out.println(findIntegers.findIntegers(1000000000));
    }
}
