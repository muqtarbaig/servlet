package org.sample.example.h2;
import java.sql.*;

public class Main {
    public static void main(String[] a)
            throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
            getConnection("jdbc:h2:mem:test", "sa", "");
        // add application code here
        conn.close();
    }
}