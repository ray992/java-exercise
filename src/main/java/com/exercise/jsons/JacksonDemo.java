package com.exercise.jsons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName JacksonDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/11/23 9:43 下午
 * @Version 1.0
 **/
public class JacksonDemo {


    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(1, "mike", new Date(), null);
        ObjectMapper objectMapper = new ObjectMapper();
       // objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println(jsonString);
        String json = "{\"id\":1,\"name\":\"mike\",\"birth\":1606143167589}";
        JsonNode node = objectMapper.readTree(json);
        System.out.println(node.get("name").asText());
        System.out.println(node.get("id").asInt());
        System.out.println(node.get("birth").asLong());
        String json_ = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";;
        JsonNode jsonObject = objectMapper.readTree(json_);
        JsonNode hobby = jsonObject.get("hobby");
        System.out.println(hobby);
        String first = hobby.get("first").asText();
        System.out.println(first);
        User parseUser = objectMapper.readValue(json, User.class);
        System.out.println(parseUser.getBirthday());
        System.out.println(parseUser.getPassword());
        LoanTrade loanTrade = new LoanTrade("abc", "efg", "hij");
        System.out.println(objectMapper.writeValueAsString(loanTrade));
        String deString = "{\"order-no\":\"123\"}";
        LoanTrade loanTrade1 = objectMapper.readValue(deString, LoanTrade.class);
        System.out.println(loanTrade1.getOrderNo());

        List<LoanTrade> loanTrades = new ArrayList<>();
        loanTrades.add(loanTrade1);
        loanTrades.add(loanTrade);
        System.out.println(objectMapper.writeValueAsString(loanTrades));

        String ss = "[{\"order-no\":\"123\",\"mch-order-no\":null},{\"order-no\":\"abc\",\"mch-order-no\":\"efg\"}]";
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, LoanTrade.class);
        List<LoanTrade> loanTrades1 = objectMapper.readValue(ss, javaType);
        System.out.println(loanTrades1);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties({})//忽略一组属性
    private static class User implements Serializable {
        private Integer id;

        private String name;

        @JsonFormat(pattern = "yyyyMMdd")
        @JsonProperty("birth") //指定属性
        private Date birthday;

        @JsonIgnore
        private String password;
    }



}
