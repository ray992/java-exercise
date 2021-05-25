package com.exercise.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Person
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/4 10:35 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {

    private String name;

    private Integer age;

    @Override
    public int compareTo(Person o) {
        return  o.age - this.age;
    }
}
