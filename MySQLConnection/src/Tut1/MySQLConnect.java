package Tut1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class MySQLConnect {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Connection con = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to DB succeed");
            Statement stm = con.createStatement();
            String query = "SELECT * FROM book";
            ResultSet rs = stm.executeQuery(query);
            System.out.println("ID    |      Title    |      Author   |     Price     ");
            System.out.println("------|---------------|---------------|------------");
            while (rs.next()) {
                System.out.printf("%-6d|%-15s|%-15s|%-15s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected to DB fail");
        }
    }
}