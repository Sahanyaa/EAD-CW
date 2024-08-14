package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public record Conn() {

    public static PreparedStatement s;

    public class conn {
        Connection c;
        Statement s;

        public conn() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
                s = c.prepareStatement("your_sql_query_here");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
