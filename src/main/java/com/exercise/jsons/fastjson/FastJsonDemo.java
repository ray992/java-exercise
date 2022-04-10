package com.exercise.jsons.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exercise.jsons.JsonOperation;
import com.exercise.jsons.User;

import java.sql.Date;
import java.util.List;

/**
 * @ClassName FastJsonDemo
 * @Description fastJson测试
 * @Author yeqiang
 * @Date 2022/2/17 下午8:18
 * @Version 1.0
 **/
public class FastJsonDemo implements JsonOperation<User, String> {


    public static void main(String[] args) {
        FastJsonDemo fastJsonDemo = new FastJsonDemo();
        User user = new User();
        user.setId(1);
        user.setName("mike");
        user.setLevel(10L);
        user.setBirthday(new Date(System.currentTimeMillis()));
        String jsonString = fastJsonDemo.toJson(user);
        System.out.println(jsonString);
        User parseUser = fastJsonDemo.fromJson(jsonString);
        System.out.println(fastJsonDemo.fromJson(jsonString));
        System.out.println(parseUser.getBirthday());
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject.get("birthday")); //输出
        jsonObject.put("a", "mk"); //添加
        System.out.println(jsonObject);
        String jsonDate = JSON.toJSONStringWithDateFormat(new Date(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss");
        System.out.println(jsonDate);
    }

    @Override
    public String toJson(User user) {
        return JSON.toJSONString(user);
    }

    @Override
    public String toJsonList(List<User> users) {
        return null;
    }

    @Override
    public User fromJson(String s) {
        return JSON.parseObject(s, User.class);
    }

    @Override
    public List<User> fromJsonList(String s) {
        return null;
    }
}
