package com.exercise.algorithm.competition.qgkj;

import java.util.*;

/**
 * @ClassName SmallestTrimmedNumbers
 * @Description 裁剪数字后查询第 K 小的数字
 * @Author yeqiang
 * @Date 2022/7/17 10:57 PM
 * @Version 1.0
 **/
public class SmallestTrimmedNumbers {

    class NumOrder {
        private String value;
        private int index;

        public NumOrder(String value, int index) {
            this.value = value;
            this.index = index;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int valueLength = nums[0].length();
        int qn = queries.length;
        int[] result = new int[qn];
        int r = 0;
        List<NumOrder> numStringList = new ArrayList<>();
        for (int[] query:queries){
            int ki = query[0];
            int trim = query[1];
            String[] copyArray = Arrays.copyOf(nums, nums.length);
            for (int i = 0; i < n; i++){
                String changeString = copyArray[i].substring(valueLength - trim);
                numStringList.add(new NumOrder(changeString, i));
            }
            Collections.sort(numStringList, new Comparator<NumOrder>() {
                @Override
                public int compare(NumOrder o1, NumOrder o2) {
                    if (!o1.value.equals(o2.value)){
                        return o1.value.compareTo(o2.value);
                    }
                    return o1.getIndex() - o2.getIndex();
                }
            });
            result[r] = numStringList.get(ki - 1).getIndex();
            numStringList.clear();
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestTrimmedNumbers smallestTrimmedNumbers = new SmallestTrimmedNumbers();
        System.out.println(Arrays.toString(smallestTrimmedNumbers.smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"}, new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}})));
        System.out.println(Arrays.toString(smallestTrimmedNumbers.smallestTrimmedNumbers(new String[]{"24", "37", "96", "04"}, new int[][]{{2, 1}, {2, 2}})));
    }
}
