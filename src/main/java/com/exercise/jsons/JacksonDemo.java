package com.exercise.jsons;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * @ClassName JacksonConfig
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/11/23 9:43 下午
 * @Version 1.0
 **/
public class JacksonConfig {

    private static ObjectMapper objectMapper;

    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        objectMapper.
    }
}
