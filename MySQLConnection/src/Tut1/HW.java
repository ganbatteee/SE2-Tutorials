package Tut1;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class HW {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/studentdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    public static void main(String[] args) {

        try {
            Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to DB succeed");
            Statement stm = con.createStatement();
            String query = "SELECT * FROM student";
            ResultSet rs = stm.executeQuery(query);
            System.out.println("      ****STUDENT TABLE****");
            System.out.println("ID    |  FullName  |   CourseID  ");
            System.out.println("------|------------|------------");
            while (rs.next()) {
                System.out.printf("%-6d|%-12s|%-12s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            query = "SELECT * FROM course";
            rs = stm.executeQuery(query);
            System.out.println("==================================");
            System.out.println("      ****COURSE TABLE**** ");
            System.out.println("ID    |  FullName  |   CourseID  ");
            System.out.println("------|------------|------------");
            while (rs.next()) {
                System.out.printf("%-6d|%-12s|%-12s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected to DB fail");
        }
    }
}
