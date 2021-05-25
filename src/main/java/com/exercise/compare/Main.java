package com.exercise.compare;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/4 10:37 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
       /* Person[] people = new Person[]{new Person("A1", 12), new Person("B1", 5), new Person("C1", 6)};
        for (Person person : people) {
            System.out.print(person.getName()+":"+person.getAge()+",");
        }
        System.out.println();
        Arrays.sort(people);
        for (Person person : people) {
            System.out.print(person.getName()+":"+person.getAge());
        }*/
        Teacher[] teachers = new Teacher[]{new Teacher("t1", 30), new Teacher("t2", 23), new Teacher("t3", 45)};
        for (Teacher teacher:teachers){
            System.out.print(teacher.getName()+" "+teacher.getAge()+",");
        }
        System.out.println();
        Arrays.sort(teachers, new TeacherComparable());
        for (Teacher teacher:teachers){
            System.out.print(teacher.getName()+" "+teacher.getAge()+",");
        }
    }
}
