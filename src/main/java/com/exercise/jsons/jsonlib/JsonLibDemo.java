package com.exercise.jsons.jsonlib;

import com.exercise.jsons.JsonOperation;
import com.exercise.jsons.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONUtils;

import java.text.SimpleDateFormat;
import java.util.List;

public class JsonLibDemo implements JsonOperation<User, String > {

    @Override
    public String toJson(User user) throws JsonProcessingException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessor(){

            private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return null;
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                return o == null ? "": sd.format(o);
            }
        });

        return JSONObject.fromObject(user, jsonConfig).toString();
    }

    @Override
    public String toJsonList(List<User> userList) {
        return null;
    }

    @Override
    public User fromJson(String s) throws JsonProcessingException {
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd"}));
        return (User) JSONObject.toBean(JSONObject.fromObject(s), User.class);
    }

    @Override
    public List<User> fromJsonList(String s) {
        return null;
    }
}
