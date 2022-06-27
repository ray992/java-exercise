package com.exercise.feature.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(1, 2);
        map.put(2,3);
        map.put(3, 4);
        map.forEach((key, value) ->{
            System.out.println(key + "," +value);
        });

        List<Integer> list = new ArrayList<Integer>(){{
            add(5);
            add(3);
            add(1);
            add(2);
        }};
       List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
       System.out.println(sortedList);

        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.listToMap();
        lambdaDemo.mapToList();
    }

    //list -> map
    public void listToMap(){
        List<User> users = new ArrayList<User>(){
            {
                add(new User("mike", "male", 20));
                add(new User("jenny", "female", 25));
                add(new User("sara", "female", 25));
                add(new User("jack", "male", 20));
            }
        };
        Map<String, List<User>> groupByMap = users.stream().collect(Collectors.groupingBy(User::getSex));
        groupByMap.forEach((sex, user) -> {
            System.out.println(sex + "----"  + user.toString());
        });
    }

    public void mapToList(){
        Map<String, User> userMap = new HashMap<>();
        userMap.put("mike", new User("mike", "male", 20));
        userMap.put("jenny", new User("jenny", "male", 20));
        userMap.put("sara", new User("sara", "male", 20));
        List<String> userList = userMap.values().stream().map(user -> user.getName()).collect(Collectors.toList());
        System.out.println(userList);
    }

    class User {
        String name;

        String sex;

        Integer age;

        public User(String name, String sex, Integer age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
