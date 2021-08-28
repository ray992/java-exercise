package com.exercise.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName CountStudents
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/30 上午9:41
 * @Version 1.0
 **/
public class CountStudents {

    public Deque<Integer> stu = new LinkedList<>();

    public Deque<Integer> sw = new LinkedList<>();

    public int countStudents(int[] students, int[] sandwiches) {
        if (sandwiches == null || students == null){
            return 0;
        }
        for (int s:students){
            stu.addLast(s);
        }
        for (int s:sandwiches){
            sw.addLast(s);
        }
        int noMatchCount = 0;
        while (true){
            if (noMatchCount == stu.size()){
                break;
            }
            int student = stu.pollFirst();
            int sand = sw.pollFirst();
            if (student == sand){
                noMatchCount = 0;
                continue;
            }
            noMatchCount++;
            sw.addFirst(sand);
            stu.addLast(student);
        }
        return noMatchCount;
    }

    public static void main(String[] args) {
        CountStudents countStudents = new CountStudents();
        int[] student = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents.countStudents(student, sandwiches));
    }
}
