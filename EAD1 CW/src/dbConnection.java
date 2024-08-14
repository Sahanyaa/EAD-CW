import javax.swing.*;
import java.sql.*;


public class dbConnection {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;

    public Connection Connectdb() {
        String dbname, user, password, url, Driver;

        dbname = "employee";
        user = "root";
        password = "";
        url = "jdbc:mysql://localhost:3306/";
        Driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url + dbname, user, password);
            return conn;
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "An error occured while establishing database connection\nKindly make sure your database is up and running.", "Database Connection error", JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
            return null;
        }
    }
}
