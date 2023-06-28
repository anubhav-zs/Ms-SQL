package com.zopsmart.crud;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class CRUDDao {
    private static Properties properties;
    private static String DB_URL, USER, PASS;

    CRUDDao() {
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream("src/main/resources/crud/db.properties");
            properties.load(ip);
            DB_URL = properties.getProperty("DB_URL");
            USER = properties.getProperty("USER");
            PASS = properties.getProperty("PASS");

        } catch (Exception e) {

        }
    }

    public void addStudent(int id, String name, int age) {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "insert into students values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            preparedStatement.execute();

            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public Student getStudent(int id) throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//      String dbURL=  "jdbc:sqlserver://localhost:2007;instanceName=crud-mssql;databaseName=student_crud;integratedSecurity = false";
//        String dbURL = "jdbc:sqlserver://localhost:2007;databaseName=student_crud;user=sa;password=reallyStrongPwd123";
//        String dbURL = "jdbc:sqlserver://localhost:2007;databaseName=student_crud";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT * FROM students WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                return new Student(studentId, name, age);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
