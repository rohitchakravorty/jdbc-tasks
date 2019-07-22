package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void jdbcBatch() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
             Statement statement = connection.createStatement();) {

            statement.addBatch("Insert into employee values(2,\"Agha\",21,\"M\")");
            statement.addBatch("Insert into employee values(3,\"Mites\",21,\"M\")");
            statement.addBatch("Insert into employee values(4,\"Paku\",21,\"M\")");
            statement.addBatch("Insert into employee values(6,\"Abinash\",21,\"M\")");
            statement.addBatch("Insert into employee values(8,\"Vishal\",21,\"M\")");
            statement.executeBatch();
            statement.clearBatch();
            ResultSet resultSet1 = statement.executeQuery("Select * from employee");
            while (resultSet1.next()) {
                System.out.println("id: " + resultSet1.getInt(1) + "Name:" + resultSet1.getString(2));
            }
            resultSet1.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
