package com.exercise.algorithm.day;

public class CountCollisions {

    public int countCollisions(String directions) {
        int res = 0;
        char[] chars = directions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 > chars.length - 1) {
                continue;
            }
            if (chars[i] == 'R' && chars[i+1] == 'S'){
                chars[i] = 'S';
                res++;
                continue;
            }
            if (chars[i] == 'S' && chars[i+1] == 'L'){
                chars[i+1] = 'S';
                res++;
            }
        }
        for (int i = 0; i < chars.length; i++){
            if (i + 1 > chars.length - 1) {
                continue;
            }
            if (chars[i] == 'R' && chars[i+1] == 'L'){
                res = res +2;
                chars[i] = 'S';
                chars[i+1] = 'S';
                continue;
            }
            if (chars[i] == 'R' && chars[i+1] == 'S'){
                res = res +1;
                chars[i] = 'S';
                continue;
            }
            if (chars[i] == 'S' && chars[i+1] == 'L'){
                res = res +1;
                chars[i+1] = 'S';
            }
        }
        for (int i = 0; i < chars.length;){
            if (chars[i] == 'R' && i+1 < chars.length -1){
                boolean matchStatus = false;
                int index = 0;
                for (int j = i+1; j < chars.length; j++){
                    if (chars[j] == 'S'){
                        matchStatus = true;
                        index = j;
                        break;
                    }
                }
                if (matchStatus){
                    res = res + (index - i);
                    i = index;
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }
        //System.out.println(chars);
        return res;
    }

    public static void main(String[] args) {
        CountCollisions countCollisions = new   CountCollisions();
        System.out.println(countCollisions.countCollisions("RLRSLL"));
        System.out.println(countCollisions.countCollisions("LLRR"));
        System.out.println(countCollisions.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
        System.out.println(countCollisions.countCollisions("LSLLSRSRLLRSRLSSSLLLLLSLSRRSRSRRR"));
         // SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSRR 1 1 1 2 1 1 2 2 2 1 1 1 1 2 1
    }
}
