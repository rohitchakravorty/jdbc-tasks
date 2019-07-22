package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    public void databaseMetaData()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {
            DatabaseMetaData metaData=connection.getMetaData();
            System.out.println("Max index length : "+metaData.getMaxIndexLength());
            System.out.println("dddd"+metaData.supportsSharding());

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}

