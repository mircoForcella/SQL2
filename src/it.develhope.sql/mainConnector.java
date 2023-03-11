package it.develhope.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class mainConnector {
    public static void main(String[] args) {


        // db parameters
        Connection conn = null;
        try{
        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "passwordhere";

        // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
