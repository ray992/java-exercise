package com.exercise.mapStruct;

import lombok.Data;


/**
 * @ClassName UserVO
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/1/4 下午7:47
 * @Version 1.0
 **/
@Data
public class UserVO {

    private Long id;

    private String name;

    private Integer age;

    private String sex;

    private String password;

    private String createAt;

    private String address;

    private double amount;
}
