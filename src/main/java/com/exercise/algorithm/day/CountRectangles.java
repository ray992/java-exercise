package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName CountRectangles
 * @Description 统计包含每个点的矩形数目
 * @Author yeqiang
 * @Date 2022/4/24 11:11 AM
 * @Version 1.0
 **/
public class CountRectangles {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int pn = points.length;
        int[] res = new int[pn];
        for (int[] re:rectangles){
            int x = re[0];
            int y = re[1];
            for (int i = 0; i < pn; i++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                if (x1 <= x && y1 <= y){
                    res[i] = res[i] + 1;
                }
            }
        }
        return res;
    }

    public int[] countRectangles2(int[][] rectangles, int[][] points){
        int rn = rectangles.length;
        int pn = points.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rn; i++){
            List<Integer> widthList = map.getOrDefault(rectangles[i][1], new ArrayList<>());
            widthList.add(rectangles[i][0]);
            map.put(rectangles[i][1], widthList);
        }
        for (int key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] ans = new int[pn];
        for (int i = 0; i < pn; i++){
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;
            for (int h = 100; h >= 1; h--){
                if (h < y){
                    break;
                }
                if (!map.containsKey(h)){
                    continue;
                }
                count += binarySearch(map.get(h), x);
            }
            ans[i] = count;
        }
        return ans;
    }

    private int binarySearch(List<Integer> widthList, int x) {
        int n = widthList.size();
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (widthList.get(mid) >= x){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return widthList.get(right) >= x ? n - right : 0;
    }


    public int[] countRectangles3(int[][] rectangles, int[][] points) {
        int n = rectangles.length;
        //哈希表key为高度，List为宽度的集合。
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int l = rectangles[i][0];
            int h = rectangles[i][1];
            List<Integer> list = map.getOrDefault(h, new ArrayList<>());
            list.add(l);
            map.put(h, list);
        }
        //由于需要对宽度的列表使用二分法，所以需要排序。
        for (int key : map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++){
            int[] p = points[i];
            int x = p[0];
            int y = p[1];
            int count = 0;
            //本题重点，枚举可能的高度，并找到当前高度下，合法的矩形数量。
            for (int h = 100; h >= 1; h--){
                //枚举高度已经比point的高度还小了，不可能再找到合法矩形了。
                if (h < y) break;
                //不存在以当前h为高度的矩形，跳过。
                if (!map.containsKey(h)) continue;
                //二分搜索，并累加答案
                count += binarySearch2(map.get(h), x);
            }
            ans[i] = count;
        }
        return ans;

    }
    public int binarySearch2(List<Integer> nums, int k){
        //二分法找nums中有多少元素大于等于k。
        int n = nums.size();
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= k){
                right = mid;
            }
            else{
                left = mid  + 1;
            }
        }
        return nums.get(right) >= k ? n - right : 0;
    }

    public static void main(String[] args) {
        CountRectangles countRectangles = new CountRectangles();
        System.out.println(Arrays.toString(countRectangles.countRectangles2(new int[][]{{1, 2}, {2, 3}, {2, 5}}, new int[][]{{2, 1}, {1, 4}})));
        System.out.println(Arrays.toString(countRectangles.countRectangles2(new int[][]{{1, 1}, {2, 2}, {3, 3}}, new int[][]{{1, 3}, {1, 1}})));
    }
}
