package com.exercise.jsons.util;


import com.alibaba.fastjson.JSON;
import com.exercise.jsons.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataInit {

    public static void main(String[] args) throws IOException {
        Connection connection = JdbcUtils.getConn();
        //initTestData(connection);
        List<User> userList = queryUserInfo(300000);
        File file = new File("data.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getName(),true);
        for (User user:userList){
            fileWriter.write(JSON.toJSONString(user)+"\n");
        }
        fileWriter.close();
    }

    public static void initTestData() {
        String sql = "insert into user(id, name, birthday, level) values (?, ?, ?, ?)";
        Connection conn = JdbcUtils.getConn();
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = conn.prepareStatement(sql);
           int i = 1;
           while (i <= 300000){
               preparedStatement.setInt(1, i);
               preparedStatement.setString(2, "test-user-"+1);
               preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
               preparedStatement.setLong(4, i);
               i++;
               preparedStatement.executeUpdate();
               System.out.println(i);
           }
           preparedStatement.close();
           conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static List<User> queryUserInfo(Integer row){
        List<User> userList = new ArrayList<>();
        String sql = "select id, name, birthday, level from user limit ?";
        Connection conn = JdbcUtils.getConn();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, row);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setLevel(resultSet.getLong("level"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
