package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
        /*Print ResultSet in reverse order*/
        public void getEmployeeDetailsInReverse()
        {


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("Select * from employee");) {
                resultSet.afterLast();
                while (resultSet.previous()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }




        }



        /*Move ResultSet to second row and print in reverse order*/
        public void getEmployeeDetailsFromSecondRowInReverse () {



                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery("Select * from employee");) {
                    resultSet.absolute(2);
                    while (resultSet.previous()) {
                        System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                    }



                } catch (Exception ex) {
                    ex.printStackTrace();
                }







        }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender (String name,String gender)
    {



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");
            PreparedStatement statement=connection.prepareStatement("Select * from employee where name= ? and gender= ?")

        )
        {
            statement.setString(1,name);
            statement.setString(2,gender);

            ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+"gender"+resultSet.getString(4));
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        }



