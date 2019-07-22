package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTransactionDemo {
    public void transactionDemo()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            connection.setAutoCommit(false);


            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
