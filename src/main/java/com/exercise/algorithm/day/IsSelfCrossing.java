package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName IsSelfCrossing
 * @Description 路径交叉
 * @Author yeqiang
 * @Date 2021/10/30 下午5:37
 * @Version 1.0
 **/
public class IsSelfCrossing {

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) return false;

        int i = 2;

        // 一直向外卷
        while (i < n && distance[i] > distance[i - 2]) i++;
        // 如果走完了，直接就可以返回不相交
        if (i == n) return false;

        // 如果向外卷转成了向内卷，i-1的长度减i-3的长度
        if (distance[i] >= distance[i - 2] - (i < 4 ? 0 : distance[i - 4])) {
            distance[i - 1] -=  i < 3 ? 0 : distance[i - 3];
        }

        // 一直向内卷，注意i先加1，这样正好跟i-1的位置相比较，相当于内卷从i-1的位置开始的
        for (++i; i < n && distance[i] < distance[i - 2]; i++);

        // 如果 i 能走完就不会相交，相反，走不完就相交了
        return i != n;
    }

    public static void main(String[] args) {
        IsSelfCrossing isSelfCrossing = new IsSelfCrossing();
        System.out.println(isSelfCrossing.isSelfCrossing(new int[]{2,1,1,2}));
    }
}
