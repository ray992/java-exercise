package com.exercise.jsons.util;

import java.sql.*;


public class JdbcUtils {


    //通过上面的工具就可以获取到properties文件中的键值从而可以加载驱动 获取链接 从而 可以增删改查
    private static Connection conn = null;




    public static Connection getConn(){

        PropertiesUtil.loadFile("jdbc.properties");
        String driver = PropertiesUtil.getPropertyValue("driver");
        String url = PropertiesUtil.getPropertyValue("url");
        String username  = PropertiesUtil.getPropertyValue("username");
        String password = PropertiesUtil.getPropertyValue("password");


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
        return conn;
    }


    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    /**
     * 通过用户名到数据库中获取凭证密码
     * @param userName
     * @return
     */
    private static String getPasswordByUserName(String userName) {
//SQL语句
        String sql = "select password from users where username = " +"'" + userName+"'";
        Connection conn = JdbcUtils.getConn();
        Statement stmt=null;
        ResultSet ret = null;
        String password=null;
        try {
            stmt = conn.createStatement();
//执行语句，得到结果集
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                //这里只查询的密码
                password = ret.getString(1);
            }
            ret.close();
            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return password;
    }
}