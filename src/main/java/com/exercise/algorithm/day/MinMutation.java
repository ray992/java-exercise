package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName MinMutation
 * @Description 最小基因变化
 * @Author yeqiang
 * @Date 2022/5/7 10:12 AM
 * @Version 1.0
 **/
public class MinMutation {

    class MuData {
        String mu;
        int times;

        public MuData(String mu, int times) {
            this.mu = mu;
            this.times = times;
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        Deque<MuData> deque = new ArrayDeque<>();
        deque.addLast(new MuData(start, 0));
        int res = -1;
        int count = 0;
        boolean hitStatus = false;
        while (!deque.isEmpty()){
            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++){
                MuData muData = deque.poll();
                for (String bankOne:bank){
                    String mu = muData.mu;
                    int diff = 0;
                    for (int t = 0; t < 8; t++){
                        if (mu.charAt(t) != bankOne.charAt(t)){
                            diff++;
                        }
                    }
                    if (diff == 1){
                        if (bankOne.equals(end)){
                            hitStatus = true;
                            break;
                        }
                        if (muData.times < 10){
                            deque.addLast(new MuData(bankOne, muData.times+1));
                        }
                    }
                }
            }
            if (hitStatus){
                res = count;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        System.out.println(minMutation.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(minMutation.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println(minMutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
