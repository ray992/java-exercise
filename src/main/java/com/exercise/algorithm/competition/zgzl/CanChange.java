package com.exercise.algorithm.competition.zgzl;

/**
 * @ClassName CanChange
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/10 11:04 AM
 * @Version 1.0
 **/
public class CanChange {

    public boolean canChange(String start, String target) {
        int n = start.length();
        for (int i = 0; i < n; i++){
            char c1 = start.charAt(i);
            char c2 = target.charAt(i);
            if (c1 == c2){
                continue;
            }
            if (c2 == 'L'){

            }
        }
        return start.equals(target);
    }

    public static void main(String[] args) {
        CanChange canChange = new CanChange();
        //System.out.println(canChange.canChange("_L__R__R_", "L______RR"));
        //System.out.println(canChange.canChange("R_L_", "__LR"));
        System.out.println(canChange.canChange("R_R", "RR_"));
    }
}
