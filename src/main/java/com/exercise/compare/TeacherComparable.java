package com.exercise.compare;

import java.util.Comparator;

/**
 * @ClassName TeacherComparable
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/4 10:36 下午
 * @Version 1.0
 **/
public class TeacherComparable implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o2.getAge() - o1.getAge();
    }
}
