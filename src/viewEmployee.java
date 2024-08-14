import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class viewEmployee extends JFrame {
JTable table;
viewEmployee(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    table=new JTable();

    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select*from employ");
        table.setModel(DbUtils.resultSetTableModel(rs));
    }catch(Exception e){
        e.printStackTrace();
    }
    JScrollPane jsp

    setSize(900,700);
    setLocation(300,100);
    setVisible(true);
    }
    public static void main(String[]args){
    new viewEmployee();
    }
}
