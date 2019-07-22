package com.stackroute.jdbc;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.BaseRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.sun.rowset.JdbcRowSetImpl;

public class RowSetDemo {

    private JdbcRowSet rowSet;
    public void getEmployeeDetails()
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Root@123");){
            Class.forName("com.mysql.cj.jdbc.Driver");
            JdbcRowSetImpl rowSet = new JdbcRowSetImpl(connection);

            rowSet.setCommand("Select * from employee");
            rowSet.execute();
            rowSet.addRowSetListener(new RowSetListener() {
        @Override
        public void rowSetChanged(RowSetEvent event) {
            System.out.println("rowset changed");
        }

        @Override
        public void rowChanged(RowSetEvent event) {
            System.out.println("row changed");

        }

        @Override
        public void cursorMoved(RowSetEvent event) {
            System.out.println("cursor moved");

        }
    });
    while (rowSet.next()) {
        System.out.println("Id:" + rowSet.getInt(1) + " Name " + rowSet.getString(2));
    }
}
catch (Exception ex) {
    ex.printStackTrace();
}


    }
}
