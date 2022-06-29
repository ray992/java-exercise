package com.exercise.algorithm.day;

/**
 * @ClassName WaysToBuyPensPencils
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 10:43 PM
 * @Version 1.0
 **/
public class WaysToBuyPensPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2){
            return 1;
        }
        int c1 = Math.min(cost1, cost2);
        int c2 = Math.max(cost1, cost2);
        long sum = 0;
        for (int cn = 0; ; cn++){
            int pn;
            int left = total - cn * c2;
            if (left < 0){
                break;
            }
            if (left >= c1){
                pn = left / c1 +1;
            }else {
                pn = 1;
            }
            sum+=pn;
        }
        return sum;
    }

    public static void main(String[] args) {
        WaysToBuyPensPencils waysToBuyPensPencils = new WaysToBuyPensPencils();
        System.out.println(waysToBuyPensPencils.waysToBuyPensPencils(20, 10, 5));
        System.out.println(waysToBuyPensPencils.waysToBuyPensPencils(5, 10, 10));
        System.out.println(waysToBuyPensPencils.waysToBuyPensPencils(100, 1, 1));
        System.out.println(waysToBuyPensPencils.waysToBuyPensPencils(10, 2, 5));
        // 5 0 | 2 0,1,2,3,4,5
        // 5 1| 2 0,1,2
        // 5 2 | 2 0
    }
}
