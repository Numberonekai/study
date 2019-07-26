package com.java.main.mybaties;


import java.sql.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/6/26 10:09
 * @Description:
 */
public class KExecutor {
    public <T> T query(String sql,Object param) {

        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","Lexprchina@9458");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(String.format(sql,param));

            while(resultSet.next()){
                Test test=new Test();
                Integer id=resultSet.getInt("id");
                String  name1=resultSet.getString("name");
                test.setId(id);
                test.setName(name1);
                test.setAge(resultSet.getInt("age"));
                test.setPassword(resultSet.getString("password"));
                test.setStartTime(resultSet.getTime("start_time"));
                System.out.println(test);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new KExecutor().query(null,null);
    }
}
