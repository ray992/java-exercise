package com.exercise.algorithm.day;

/**
 * @ClassName ChalkReplacer
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/10 上午8:08
 * @Version 1.0
 **/
public class ChalkReplacer {

    public int chalkReplacer(int[] chalk, int k) {
        long oneCycleConsume = 0L;
        for (int c:chalk){
            oneCycleConsume+=c;
        }
        long remain = 0;
        if (k > oneCycleConsume){
            remain = k%oneCycleConsume;
        }else {
            remain = k;
        }
        long canMatchCount = 0L;
        int res = 0 ;
        for (int i = 0; i < chalk.length; i++){
            canMatchCount+=chalk[i];
            if (canMatchCount > remain){
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ChalkReplacer chalkReplacer = new ChalkReplacer();
        System.out.println(chalkReplacer.chalkReplacer(new int[]{5,1,5}, 22));
        System.out.println(chalkReplacer.chalkReplacer(new int[]{3,4,1,2}, 25));
        System.out.println(chalkReplacer.chalkReplacer(new int[]{5,1,5}, 7));
    }
}
