package com.stackroute.jdbc;

import java.sql.DatabaseMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
//        simpleJdbcDemo.getEmployeeDetails();
//        System.out.println("\n");
//        simpleJdbcDemo.getEmployeeDetailsInReverse();
//        System.out.println("\n");
//        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
//        System.out.println("\n");
//        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Rohit","M");

        RowSetDemo rs=new RowSetDemo();
        rs.getEmployeeDetails();

//        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
//        resultSetMetadataDemo.resultSetMetaData();
//
//
//        DatabaseMetadataDemo databaseMetaData=new DatabaseMetadataDemo();
//        databaseMetaData.databaseMetaData();

//        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
//        jdbcBatchDemo.jdbcBatch();

    }
}
