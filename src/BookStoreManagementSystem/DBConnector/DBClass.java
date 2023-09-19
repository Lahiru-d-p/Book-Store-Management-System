package BookStoreManagementSystem.DBConnector;

import java.sql.*;

public class DBClass {
    public static void connection(){
        try {
            //constant values for connect database
            final String MySQL_ServerUrl = "jdbc:mysql://localhost:3306/";
            final String databaseUrl = "jdbc:mysql://localhost:3306/BookStoreManagementSystem";
            final String username = "root";
            final String password = "root";

            //Connect MySQL server and create database if not already created
            Connection Connection = DriverManager.getConnection(MySQL_ServerUrl,username,password);
            Statement Statement = Connection.createStatement();
            Statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BookStoreManagementSystem");
            Statement.close();
            Connection.close();

            //Connect database and create tables if not already created
            Connection connection = DriverManager.getConnection(databaseUrl,username,password);
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE("
                    +"emID VARCHAR(10) NOT NULL,"
                    +"emRole VARCHAR(15) NOT NULL,"
                    +"emName VARCHAR(100) NOT NULL,"
                    +"emAddress VARCHAR(150) NOT NULL,"
                    +"emDOB VARCHAR(30) NOT NULL,"
                    +"emContactNum VARCHAR(12) NOT NULL,"
                    +"emSalary VARCHAR(15) NOT NULL,"
                    +"emPSW VARCHAR(15) NOT NULL,"
                    +"PRIMARY KEY(emID),"
                    +"UNIQUE KEY emID_UNIQUE(emID)"
                    +")";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS BOOK("
                    +"bookID VARCHAR(10) NOT NULL,"
                    +"bookTitle VARCHAR(100) NOT NULL,"
                    +"bookAuthor VARCHAR(50) NOT NULL,"
                    +"bookPublisher VARCHAR(50) NOT NULL,"
                    +"bookYear VARCHAR(20) NOT NULL,"
                    +"bookCategory VARCHAR(30) NOT NULL,"
                    +"bookPrice VARCHAR(10) NOT NULL,"
                    +"bookQTY INT(10) NOT NULL,"
                    +"PRIMARY KEY(bookID),"
                    +"UNIQUE KEY bookID_UNIQUE(bookID)"
                    +")";
            statement.executeUpdate(sql);
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            //constant values for connect database
            final String databaseUrl = "jdbc:mysql://localhost:3306/BookStoreManagementSystem";
            final String username = "root";
            final String password = "root";

            //Connect database
            return DriverManager.getConnection(databaseUrl, username, password);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}