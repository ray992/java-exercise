package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName MinimumRounds
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/17 10:48 AM
 * @Version 1.0
 **/
public class MinimumRounds {

    public int minimumRounds(int[] tasks) {
        //Arrays.sort(tasks);
        Map<Integer, Integer> taskMap = new HashMap<>();
        for (int t:tasks){
            taskMap.put(t, taskMap.getOrDefault(t, 0)+1);
        }
        int times = 0;
        for (Map.Entry<Integer, Integer> map:taskMap.entrySet()){
            int curCount = map.getValue();
            int count = bfs(curCount);
            if (count == -1){
                return -1;
            }
            times+=count;
        }
        return times;
    }

    public int bfs(int count){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(2);
        deque.offer(3);
        int minCount = Integer.MAX_VALUE;
        int acCount = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int rs = deque.poll();
                if (rs > count){
                    continue;
                }
                if (rs == count){
                    if (acCount < minCount){
                        minCount = acCount;
                    }
                    continue;
                }
                deque.offer(rs+2);
                deque.offer(rs+3);
            }
            acCount++;
        }
        return minCount == Integer.MAX_VALUE ? - 1:minCount;
    }

    public static void main(String[] args) {
        MinimumRounds minimumRounds = new MinimumRounds();
        System.out.println(minimumRounds.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println(minimumRounds.minimumRounds(new int[]{2,3,2}));
        System.out.println(minimumRounds.minimumRounds(new int[]{513,513,511,515,519,519,515,510,514,513,519,514,520,517,513,520,511,518,512,511,511,515,514,515,519,513,513,518,515,511,513,512,513,512,517,511,512,520,518,515,519,520,514,510,511,516,513,516,519,517,512,518,515,518,514,520,517,519,514,515,519,510,513,520,513,514,512,515,515,511,515,516,516,514,512,513,512,514,515,516,517,519,512,512,520,519,520,510,517,517,514,511,515,511,512,519,518,515,520,517,519,520,513,517,512,511,516,514,520,512,512,518,513,510,519,512,514,519,517,519,520,510,514,512,517,512,520,519,513,512,515,510,517,517,518,516,513,513,518,515,514,516,513,513,515,519,519,510,515,511,520,510,511,520,510,520,520,515,519,514,516,516,519,514,516,514,520,511,520,511,514,516,512,519,511,520,515,519,516,513,516,513,516,516,515,519,517,514,517,519,514,512,516,513,518,511,520,510,516,510,517,516,517,510,514,520,518,518,517,517,514,520,512,514,513,520,519,513,520,510,518,510,520,511,511,510,518,510,519,518,514,510,511,519,511,510,517,514,518,518,513,511,514,517,514,516,519,514,515,520,514,514,519,512,510,514,517,516,519,518,520,514,516,519,514,518,511,519,515,520,519,514,517,514,520,516,510,511,515,512,510,511,512,513,513,517,513,510,519,510,520,517,519,515,513,516,510,520,514,511,510,520,517,518,517,515,516,520,520,512,514,515,513,514,514,512,514,516,513,512,510,518,512,520,515,510,511,516,514,519,511,511,510,510,520,517,520,515,517,516,514,520,514,519,519,513,518,511,510,517,520,516,518,513,514,510,515,519,511,517,512,516,517,520,515,512,512,519,511,510,520,517,510,517,514,512,516,514,517,511,517,513,513,514,514,519,519,517,519,516,517,518,514,515,513,518,514,510,515,516,519,512,514,517,513,518,518,511,511,511,514,515,512,513,519,520,512,520,512,520,513,513,515,520,511,513,520,517,510,511,520,516,518,510,511,516,516,511,511,511,516,519,517,518,510,520,511,516,520,511,514,515,510,519,515,519,512,520,512,513,518,517,519,513,510,519,519,514,512,515,510,515,512,514,517,518,516,511,513,510,516,519,511,512,518,512,519,510,512,514,520,512,513,518,514,511,520,517,511,51}));
        System.out.println(minimumRounds.minimumRounds(new int[]{3,3}));
        System.out.println(minimumRounds.minimumRounds(new int[]{1018,1016,1014,1016,1015,1014,1017,1019,1011,1018,1012,1019,1019,1017,1010,1017,1013,1016,1018,1019,1014,1014,1020,1019,1016,1017,1015,1013,1010,1020,1020,1020,1014,1014,1010,1012,1018,1013,1014,1013,1013,1019,1013,1015,1014,1014,1018,1016,1017,1013,1013,1018,1011,1016,1011,1017,1013,1019,1018,1020,1012,1011,1014,1016,1012,1016,1019,1014,1017,1011,1013,1017,1019,1013,1017,1014,1018,1016,1012,1016,1016,1018,1018,1020,1010,1020,1013,1018,1013,1020,1010,1012,1015,1015,1010,1019,1013,1016,1015,1012,1015,1019,1010,1012,1019,1019,1017,1015,1015,1016,1016,1010,1014,1014,1017,1017,1020,1018,1016,1014,1019,1015,1016,1012,1019,1011,1012,1013,1010,1018,1019,1013,1017,1015,1016,1018,1018,1020,1018,1011,1020,1016,1016,1014,1017,1019,1017,1011,1015,1014,1019,1012,1014,1017,1020,1015,1017,1013,1012,1018,1019,1010,1018,1012,1011,1020,1016,1016,1010,1018,1018,1017,1020,1015,1010,1019,1018,1019,1019,1012,1013,1019,1013,1014,1016,1015,1016,1015,1015,1015,1019,1018,1015,1011,1019,1013,1020,1014,1020,1016,1010,1013,1012,1019,1015,1012,1016,1018,1011,1012,1020,1018,1010,1015,1010,1017,1015,1017,1010,1016,1012,1013,1015,1010,1010,1019,1012,1016,1013,1011,1010,1020,1018,1013,1019,1012,1016,1013,1012,1019,1012,1012,1014,1020,1013,1015,1016,1020,1014,1013,1017,1016,1016,1015,1016,1020,1011,1013,1015,1018,1013,1014,1010,1017,1010,1017,1016,1020,1019,1015,1012,1018,1011,1017,1011,1012,1018,1010,1011,1012,1010,1012,1020,1019,1010,1011,1019,1010,1011,1017,1017,1010,1013,1017,1015,1019,1010,1015,1018,1017,1012,1015,1020,1012,1017,1019,1017,1019,1015,1016,1016,1020,1011,1020,1020,1015,1015,1017,1020,1015,1016,1020,1013,1016,1020,1018,1012,1020,1019,1010,1013,1020,1011,1010,1011,1012,1014,1011,1016,1014,1011,1015,1011,1012,1016,1018,1019,1015,1019,1013,1016,1014,1016,1013,1019,1016,1017,1017,1017,1015,1010,1012,1016,1014,1020,1015,1012,1012,1011,1011,1015,1013,1010,1019,1010,1010,1012,1017,1020,1018,1019,1012,1017,1010,1013,1020,1011,1013,1016,1017,1018,1015,1017,1013,1017,1017,1019,1016,1010,1011,1017,1015,1020,1011,1010,1012,1020,1013,1012,1018,1019,1016,1017,1016,1016,1020,1011,1011,1012,1011,1018,1010,1018,1013,1014,1014,1011,1010,1015,1016,1016,1015,1011,1011,1018,1013,1011,1010,1010,1014,1018,1015,1012,1015,1015,1012,1019,1014,1010,1017,1010,1012,1016,1012,1015,1019,1019,1010,1019,1014,1014,1013,1010,1010,1016,1014,1019,1019,1020,1010,1013,1011,1016,1015,1010,1016,1011,1020,1010,1020,1011,1015,1016,1018,1015,1016,1012,1011,1016,1010,1018,1010,1016,1013,1011,1016,1011,1014,1011,1017,1012,1012,1013,1015,1014,1017,1014,1012,1017,1013,1012,1020,1013,1015,1014,1010,1014,1014,1014,1019,1014,1013,1017,1010,1010,1012,1011,1013,1018,1016,1011,1018,1010,1013,1016,1017,1019,1015,1016,1015,1016,1012,1019,1013,1013,1012,1017,1013,1011,1012,1019,1012,1020,1019,1017,1020,1014,1017,1020,1018,1011,1016,1015,1010,1017,1013,1017,1018,1010,1019,1014,1011,1010,1016,1020,1013,1011,1020,1013,1015,1014,1013,1015,1010,1014,1019,1016,1012,1010,1020,1020,1011,1015,1018,1012,1010,1012,1017,1017,1015,1012,1019,1012,1010,1018,1011,1012,1017,1018,1017,1019,1010,1012,1012,1010,1016,1016,1019,1017,1017,1017,1013,1016,1013,1017,1017,1010,1012,1019,1014,1019,1019,1011,1019,1018,1011,1016,1012,1013,1017,1017,1014,1016,1016,1015,1015,1018,1019,1015,1014,1019,1016,1013,1011,1011,1017,1012,1015,1016,1010,1012,1010,1012,1012,1013,1014,1019,1018,1014,1014,1014,1015,1018,1019,1012,1011,1012,1010,1019,1018,1011,1010,1017,1012,1011,1014,1018,1019,1016,1014,1012,1015,1019,1016,1013,1018,1014,1010,1012,1018,1012,1015,1010,1010,1018,1019,1013,1017,1019,1019,1018,1010,1012,1019,1016,1015,1018,1015,1012,1016,1020,1015,1017,1019,1013,1020,1019,1011,1010,1015,1015,1018,1011,1011,1010,1016,1010,1010,1011,1014,1017,1011,1010,1020,1011,1016,1015,1014,1011,1018,1018,1020,1015,1011,1013,1017,1011,1015,1012,1018,1016,1012,1012,1014,1010,1012,1012,1010,1012,1014,1010,1017,1012,1017,1011,1011,1014,1013,1018,1015,1013,1018,1014,1019,1014,1018,1020,1019,1016,1020,1013,1015,1013,1011,1018,1010,1019,1017,1018,1013,1011,1017,1013,1019,1014,1016,1016,1014,1015,1012,1010,1018,1015,1011,1015,1016,1019,1014,1020,1016,1011,1011,1015,1010,1020,1012,1018,1011,1013,1016,1010,1017,1017,1018,1011,1018,1011,1011,1016,1019,1010,1017,1012,1020,1019,1017,1019,1019,1011,1010,1015,1012,1011,1012,1016,1016,1012,1018,1014,1014,1014,1014,1016,1018,1011,1015,1019,1019,1020,1013,1012,1014,1015,1011,1011,1019,1015,1016,1019,1016,1015,1013,1017,1012,1014,1019,1018,1015,1011,1019,1020,1017,1012,1017,1019,1017,1015,1013,1018,1013,1019,1013,1014,1013,1010,1020,1019,1014,1012,1010,1017,1020,1019,1012,1014,1019,1011,1012,1016,1018,1011,1015,1014,1017,1018,1017,1011,1012,1010,1014,1020,1017,1011,1010,1020,1019,1017,1017,1012,1017,1017,1010,1020,1017,1013,1011,1019,1012,1012,1020,1012,1018,1011,1018,1010,1015,1014,1011,1016,1015,1020,1015,1015,1013,1015,1015,1013,1012,1012,1010,1014,1010,1019,1011,1020,1016,1010,1010,1016,1012,1012,1015,1011,1011,1012,1011,1017,1011,1015,1018,1010,1010,1017,1017,1015,1017,1016,1015,1014,1017}));
    }
}
