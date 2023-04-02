package it.develhope.sql;

import java.sql.*;

public class mainConnector {
    public static void main(String[] args) {

        Connection connection = null;
        try{
        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "passwordhere";
        // create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
        // create students table
            String createStudents = "CREATE TABLE students (" +
                    "student_id INT(10) NOT NULL AUTO_INCREMENT," +
                    "last_name VARCHAR(30)," +
                    "first_name VARCHAR(30)," +
                    "PRIMARY KEY (student_id))";
            statement.executeUpdate(createStudents);
        // populate students table
            String insertQueryStudents = "INSERT INTO students (last_name, first_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQueryStudents);
            preparedStatement.setString(1,"Connor");
            preparedStatement.setString(2,"John");
            preparedStatement.executeUpdate();
            preparedStatement.setString(1,"Connor");
            preparedStatement.setString(2,"Sarah");
            preparedStatement.executeUpdate();
            preparedStatement.setString(1,"Schwarzenegger");
            preparedStatement.setString(2,"Arnold");
            preparedStatement.executeUpdate();
            preparedStatement.setString(1,"Loken");
            preparedStatement.setString(2,"Kristanna");
            preparedStatement.executeUpdate();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
