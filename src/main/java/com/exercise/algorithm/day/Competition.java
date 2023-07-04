package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Competition
 * @Description 比赛队伍配对
 * @Author yeqiang
 * @Date 2022/7/16 5:51 PM
 * @Version 1.0
 **/
public class Competition {

    public static String[] t1 = {"a", "b", "c"};
    public static String[] t2 = {"x", "y", "z"};
    public List<List<String>>  allList = new ArrayList<>();
    // ax,  by, cz
    // ax,  bz, cy
    // ay,  bz, cx
    // ay,  bx, cz
    // az,  bx, cy
    // az,  by, cx


    public static void dfs(String[] team, int len, int depth, List<String> path, boolean[] used, List<List<String>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < team.length; i++){
            if (used[i]){
                continue;
            }
            path.add(team[i]);
            used[i] = true;
            dfs(team, len, depth+1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static List<List<String>> permute(String[] team) {
        List<List<String>> res = new ArrayList<>();
        if (team.length == 0){
            return res;
        }
        boolean[] used = new boolean[team.length];
        dfs(team, team.length, 0, new ArrayList<>(), used, res);
        return res;
    }




    public static void main(String[] args) {


    }
}
