package com.exercise.algorithm.day;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName AllPermute
 * @Description 全排列
 * @Author yeqiang
 * @Date 2021/8/30 下午5:57
 * @Version 1.0
 **/
public class AllPermute {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPermute allPermute = new AllPermute();
        System.out.println(allPermute.permute(new int[]{1,2,3}));
    }
}
