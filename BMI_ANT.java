package bmi_ant;

import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BMI_ANT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Launch the UI
       
        BMILogin up = new BMILogin();
        up.setVisible(true);
       
        
    }
}

class DBConnection {
    public static Connection DB_con() {
        String url = "jdbc:mysql://localhost:3306/bmi_database";
        String user = "root";
        String password = "";  // Use empty string if there's no password
        Connection conn;
        conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}
