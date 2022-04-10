package com.exercise.jsons.gson;

import com.exercise.jsons.JsonOperation;
import com.exercise.jsons.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GsonDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/2/17 下午7:42
 * @Version 1.0
 **/
public class GsonDemo implements JsonOperation<User, String> {

    static Gson gson = null;
    static Gson gson1 = null;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd"); //日期格式
        gson1 = gsonBuilder.create();
        gson = new Gson();
    }

    public static void main(String[] args) {
        GsonDemo gsonDemo = new GsonDemo();
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("mike");
        user.setLevel(10L);
        user.setBirthday(new Date(System.currentTimeMillis()));
        userList.add(user);
        String jsonString = gsonDemo.toJson(user);
        System.out.println(jsonString);
        System.out.println(gsonDemo.fromJson(jsonString));

        user = new User();
        user.setId(2);
        user.setName("jenny");
        user.setLevel(100L);
        user.setBirthday(new Date(System.currentTimeMillis()));
        userList.add(user);
        String jsonStringList = gsonDemo.toJsonList(userList);
        System.out.println(jsonStringList);
        System.out.println(gsonDemo.fromJsonList(jsonStringList));
    }

    @Override
    public String toJson(User user) {
        return gson1.toJson(user);
    }

    @Override
    public String toJsonList(List<User> users) {
        return gson.toJson(users);
    }

    @Override
    public User fromJson(String s) {
        return gson1.fromJson(s, User.class);
    }

    @Override
    public List<User> fromJsonList(String s) {
        return gson.fromJson(s, new TypeToken<List>() {}.getType());
    }
}
