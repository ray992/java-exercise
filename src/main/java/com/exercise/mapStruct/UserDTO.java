package com.exercise.mapStruct;


import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private String password;

    private Date createTime;
}
