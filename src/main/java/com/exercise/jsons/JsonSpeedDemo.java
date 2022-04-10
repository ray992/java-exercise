package com.exercise.jsons;

import com.exercise.jsons.fastjson.FastJsonDemo;
import com.exercise.jsons.gson.GsonDemo;
import com.exercise.jsons.jackson.JacksonDemo;
import com.exercise.jsons.jsonlib.JsonLibDemo;
import com.exercise.jsons.util.DataInit;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonSpeedDemo {

    public static void objectToJson() throws JsonProcessingException {
        JsonSpeedDemo jsonSpeedDemo = new JsonSpeedDemo();
        DataInit dataInit = new DataInit();
        List<User> userList = dataInit.queryUserInfo(1000000);
        long sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.gsonToStringTest(userList);
            System.out.println("gson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("gson序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.fastJsonToStringTest(userList);
            System.out.println("fastJson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("fastJson序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.jacksonToStringTest(userList);
            System.out.println("jackson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("Jackson序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.jsonLibToStringTest(userList);
            System.out.println("jsonLib当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("jsonLib序列化平均耗时："+sumCostTime/3);
    }

    public static void jsonToObject() throws IOException {
        JsonSpeedDemo jsonSpeedDemo = new JsonSpeedDemo();
        List<String> jsonStringList = new ArrayList<>();
        FileReader fileReader = new FileReader(new File("data.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str ;
        while ((str = bufferedReader.readLine()) != null){
            jsonStringList.add(str);
        };
        long sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.gsonTestToObjectTest(jsonStringList);
            System.out.println("gson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("gson反序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.fastJsonToObjectTest(jsonStringList);
            System.out.println("fastJson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("fastJson反序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.jacksonToObjectTest(jsonStringList);
            System.out.println("jackson当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("Jackson反序列化平均耗时："+sumCostTime/3);
        sumCostTime = 0;
        for (int i = 0; i < 3; i++){
            long curTime = jsonSpeedDemo.jsonLibToObjectTest(jsonStringList);
            System.out.println("jsonLib当前耗时:"+curTime);
            sumCostTime += curTime;
        }
        System.out.println("jsonLib反序列化平均耗时："+sumCostTime/3);
        bufferedReader.close();
        fileReader.close();
    }

    public static void main(String[] args) throws IOException {
        //object -- > json
        //objectToJson();
        //json -- > object
        jsonToObject();
        // 选择gson的原因
    }

    public long gsonToStringTest(List<User> userList){
        GsonDemo gsonDemo = new GsonDemo();
        long startTime = System.currentTimeMillis();
        for (User user:userList){
           String jsonString = gsonDemo.toJson(user);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long fastJsonToStringTest(List<User> userList){
        FastJsonDemo fastJsonDemo = new FastJsonDemo();
        long startTime = System.currentTimeMillis();
        for (User user:userList){
            String jsonString = fastJsonDemo.toJson(user);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long jacksonToStringTest(List<User> userList) throws JsonProcessingException {
        JacksonDemo jacksonDemo = new JacksonDemo();
        long startTime = System.currentTimeMillis();
        for (User user:userList){
            String jsonString = jacksonDemo.toJson(user);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long jsonLibToStringTest(List<User> userList) throws JsonProcessingException {
        JsonLibDemo jsonLibDemo = new JsonLibDemo();
        long startTime = System.currentTimeMillis();
        for (User user:userList){
            String jsonString = jsonLibDemo.toJson(user);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long gsonTestToObjectTest(List<String> jsonStringList){
        GsonDemo gsonDemo = new GsonDemo();
        long startTime = System.currentTimeMillis();
        for (String jsonString:jsonStringList){
           gsonDemo.fromJson(jsonString);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long fastJsonToObjectTest(List<String> jsonStringList){
        FastJsonDemo fastJsonDemo = new FastJsonDemo();
        long startTime = System.currentTimeMillis();
        for (String jsonString:jsonStringList){
            fastJsonDemo.fromJson(jsonString);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long jacksonToObjectTest(List<String> jsonStringList) throws JsonProcessingException {
        JacksonDemo jacksonDemo = new JacksonDemo();
        long startTime = System.currentTimeMillis();
        for (String jsonString:jsonStringList){
            jacksonDemo.fromJson(jsonString);
        }
        return  (System.currentTimeMillis() - startTime);
    }

    public long jsonLibToObjectTest(List<String> jsonStringList) throws JsonProcessingException {
        JsonLibDemo jsonLibDemo = new JsonLibDemo();
        long startTime = System.currentTimeMillis();
        for (String jsonString:jsonStringList){
            jsonLibDemo.fromJson(jsonString);
        }
        return  (System.currentTimeMillis() - startTime);
    }
}
