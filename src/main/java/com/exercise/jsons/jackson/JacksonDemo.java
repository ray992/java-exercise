package com.exercise.jsons.jackson;

import com.exercise.jsons.JsonOperation;
import com.exercise.jsons.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JacksonDemo implements JsonOperation<User, String> {

     static  ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String toJson(User user) throws JsonProcessingException {
        return objectMapper.writeValueAsString(user);
    }

    @Override
    public String toJsonList(List<User> userList) {
        return null;
    }

    @Override
    public User fromJson(String s) throws JsonProcessingException {
        return objectMapper.readValue(s, User.class);
    }

    @Override
    public List<User> fromJsonList(String s) {
        return null;
    }
}
