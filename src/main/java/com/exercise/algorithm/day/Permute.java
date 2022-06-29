package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName Permute
 * @Description 全排列
 * @Author yeqiang
 * @Date 2022/4/18 11:02 PM
 * @Version 1.0
 **/
public class Permute {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfsUnique(nums, nums.length, 0, path, used, res);
        return res;
    }

    public void dfsUnique(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, nums.length, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(nums, nums.length, 0, path, used, res);
        return res;
    }

    public void dfs2(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs2(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permuteUnique(new int[]{1,1,2}));
    }
}
