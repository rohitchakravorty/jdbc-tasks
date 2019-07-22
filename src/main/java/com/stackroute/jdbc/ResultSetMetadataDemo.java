package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void resultSetMetaData()
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
            ResultSetMetaData metaData=resultSet.getMetaData();
            System.out.println("No.of columns"+metaData.getColumnCount());
            System.out.println(metaData);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    }
