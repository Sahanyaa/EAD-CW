import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;

    viewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl=new JLabel("Search by Employee Id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);

        cemployeeId=new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);

        try {
            var c = new Conn();

            ResultSet rs = Conn.s.executeQuery("SELECT * FROM employ");
            Object DbUtils;
            DbUtils = null;

            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
            Throwable e;
            e = null;
            e.printStackTrace();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = Conn.s.executeQuery("SELECT * FROM employ");
            Object DbUtils;
            DbUtils = null;

            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
            Throwable e;
            e = null;
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
    }





    public static void main(String[] args) {
        viewEmployee viewEmployee = new viewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
