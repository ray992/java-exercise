package com.exercise.compare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ComparableDemo
 * @Description 实现Comparable接口和自定义比较器，进行排序
 * @Author yeqiang
 * @Date 2020/10/8 10:50 下午
 * @Version 1.0
 **/
public class ComparableDemo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("s1", 10);
        Student student2 = new Student("s2", 7);
        Student student3 = new Student("s3", 8);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Collections.sort(studentList);
        System.out.println("***从小到大***");
        for (Student s:studentList){
            System.out.println(s.getName() + " "+s.getAge());
        }
        System.out.println("***从大到小***");
        Collections.sort(studentList, new MyComparator());
        for (Student s:studentList){
            System.out.println(s.getName() + " "+s.getAge());
        }
    }

}

class Student implements Comparable<Student>{

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }


}

/**
* @Name
* @Description 自定义比较器
* @Date 2020/10/8 11:05 下午
* @params
* @return
**/
class MyComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}