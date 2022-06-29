package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName FindTheWinner
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/4 9:26 AM
 * @Version 1.0
 **/
public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        Deque<Integer> personDeque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            personDeque.addLast(i);
        }
        int count = 0;
        int curPersonCount = n;
        while (!personDeque.isEmpty()){
            if (curPersonCount == 1){
                break;
            }
            int pollPerson = personDeque.pollFirst();
            count++;
            if (count == k){
                count = 0;
                curPersonCount--;
            }else {
                personDeque.addLast(pollPerson);
            }
        }
        return personDeque.poll();
    }

    public int findTheWinner2(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++){
            ans = (ans + k) % i;
        }
        return ans + 1;
    }


    public static void main(String[] args) {
        FindTheWinner findTheWinner = new FindTheWinner();
        System.out.println(findTheWinner.findTheWinner2(5, 2));
        System.out.println(findTheWinner.findTheWinner2(6, 5));
    }
}
