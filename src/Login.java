import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField passwordField;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        setSize(600, 300);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            char[] passwordChars = passwordField.getPassword();

            // Establish database connection (replace the placeholders with your actual database details)
            String jdbcUrl = "jdbc:mysql://localhost:3306/employee";
            String dbUsername = "root";
            String dbPassword = "";
            String driver = "com.mysql.cj.jdbc.Driver"; // Updated driver class

            Class.forName(driver);
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // Create a PreparedStatement to avoid SQL injection
            String query = "SELECT * FROM login WHERE username=? AND password=?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, new String(passwordChars));

                // Execute the query
                ResultSet rs = pstmt.executeQuery();



                if (rs.next()) {
                    // Valid credentials, close the database connection
                    con.close();
                    setVisible(false);
                } else {
                    // Invalid credentials
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to the database");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
