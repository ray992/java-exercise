package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName LengthLongestPath
 * @Description 文件中最长绝对路径
 * @Author yeqiang
 * @Date 2022/4/20 9:16 PM
 * @Version 1.0
 **/
public class LengthLongestPath {

    //dir/subdir2/subsubdir2/file2.ext

    public int lengthLongestPath(String input) {
        int lon = 0;
        String[] lineArray = input.split("\n");
        int[] depthLength = new int[lineArray.length];
        for (String line:lineArray){
            int depth = getDepth(line);
            if (depth == 0){
                depthLength[depth] = line.length();
            }else {
                depthLength[depth] = depthLength[depth - 1] + 1 + line.length() - depth;
            }
            if (line.contains(".")){
                lon = Math.max(lon, depthLength[depth]);
            }
        }
        return lon;
    }

    public int getDepth(String line){
        int depth = 0;
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == '\t'){
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        LengthLongestPath lengthLongestPath = new LengthLongestPath();
        //System.out.println(lengthLongestPath.lengthLongestPath("a"));
        //System.out.println(lengthLongestPath.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
        System.out.println(lengthLongestPath.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(lengthLongestPath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
