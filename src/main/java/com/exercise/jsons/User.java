package com.exercise.jsons;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/2/17 下午7:43
 * @Version 1.0
 **/
public class User implements Serializable {

    private Integer id;

    private String name;

    private Long level;

    private Date birthday;

    public User() {
    }

    public User(Integer id, String name, Long level, Date birthday) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", birthday=" + birthday +
                '}';
    }
}
