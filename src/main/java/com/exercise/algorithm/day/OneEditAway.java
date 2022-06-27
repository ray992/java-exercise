package com.exercise.algorithm.day;

public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first.isEmpty()){
            first = " ";
        }
        if (second.isEmpty()){
            second = " ";
        }
        int n1 = first.length();
        int n2 = second.length();
        int misCount = 0;
        if (n1 == n2){
            for (int i = 0; i < n1; i++){
                if (first.charAt(i) == second.charAt(i)){
                    continue;
                }
                misCount ++;
                if (misCount > 1){
                    return false;
                }
            }
        }else {
            if (Math.abs(n1 - n2) > 1){
                return false;
            }
            int actN = Math.max(n1, n2);
            int t = 0, r = 0;
            for (int i = 0 ; i < actN; i++, t++, r++){
                if (misCount > 1){
                    return false;
                }
                if (t > n1 - 1 || r > n2 - 1){
                    misCount++;
                    continue;
                }
                char c1 = first.charAt(t);
                char c2 = second.charAt(r);
                if (c1 == c2){
                    continue;
                }
                if (n1 > n2){
                    r--;
                }
                if (n1 < n2){
                    t--;
                }
                misCount ++;
            }
        }
        return misCount <= 1;

    }

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        //System.out.println(oneEditAway.oneEditAway("pale", "ple"));
        //System.out.println(oneEditAway.oneEditAway("pale", "pall"));
        //System.out.println(oneEditAway.oneEditAway("pales", "pal"));
        //System.out.println(oneEditAway.oneEditAway("", "a"));
        System.out.println(oneEditAway.oneEditAway("a", "ab"));
        System.out.println(oneEditAway.oneEditAway("islander", "slander"));
        System.out.println(oneEditAway.oneEditAway("teacher", "taches"));
        //"islander"
        //"slander"
    }
}
