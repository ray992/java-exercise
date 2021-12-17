package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ScheduleCourse
 * @Description 课程表
 * @Author yeqiang
 * @Date 2021/12/14 上午9:49
 * @Version 1.0
 **/
public class ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        // 按课程截止时间升序排序
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // 大根堆，学习时长更长的在堆顶
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 记录总学习时长
        int total = 0;
        // 按截止时间从近到远遍历课程
        for (int[] course : courses) {
            // 如果总时长不会超过截止时间，那么，当前这门课程可以选择，直接入堆
            if (total + course[0] <= course[1]) {
                total += course[0];
                heap.offer(course);
            } else if (!heap.isEmpty() && heap.peek()[0] > course[0]) {
                // 出现冲突，优先选择学习时长更短的课程
                total = total - heap.poll()[0] + course[0];
                heap.offer(course);
            }
        }
        // 堆中有多少课程就是结果
        return heap.size();
    }

    class Course {

        private Integer duration;

        private Integer lastDay;

        public Course(Integer duration, Integer lastDay) {
            this.duration = duration;
            this.lastDay = lastDay;
        }

        public Integer getDuration() {
            return duration;
        }

        public Integer getLastDay() {
            return lastDay;
        }
    }

    class MyComparator implements Comparator<Course>{

        @Override
        public int compare(Course o1, Course o2) {
            return o1.lastDay - o2.lastDay;
        }
    }
    class MyComparator1 implements Comparator<Course>{

        @Override
        public int compare(Course o1, Course o2) {
            return o2.duration - o1.duration;
        }
    }



    public static void main(String[] args) {
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        int[][] c = new int[][]{{100, 200},{200, 1300},{1000, 1250},{2000, 3200}};
        System.out.println(scheduleCourse.scheduleCourse(c));
        int[][] c1 = new int[][]{{1, 2}};
        System.out.println(scheduleCourse.scheduleCourse(c1));
        int[][] c2 = new int[][]{{3, 2},{4,3}};
        System.out.println(scheduleCourse.scheduleCourse(c2));
        int[][] c3 = new int[][]{{5, 5},{4,6},{2,6}};
        System.out.println(scheduleCourse.scheduleCourse(c3));
    }
}
