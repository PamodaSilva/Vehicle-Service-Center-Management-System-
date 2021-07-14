import com.test.Database;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Payment extends JFrame {
    public JPanel Payment;
    private JTextField textField1;
    private JButton searchButton;
    private JTextField textField3;
    private JButton findButton;
    private JTable Table1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField2;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JScrollPane table_1;
    private JButton backToAdminPageButton;

    public void table(String start_date , String end_date) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT `Service ID`,`Vehicle Number`,`Bill`,`Service Type`,`Date` FROM `payment` WHERE `Date` BETWEEN ? AND ? ");
            preparedStatement.setString(1,start_date);
            preparedStatement.setString(2,end_date);
            ResultSet rs = preparedStatement.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));

            preparedStatement.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null," Have some Error !"+ e.getMessage());
        }
    }

    public void Bill(String start_date , String end_date){
        try {
            Connection con = Database.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT SUM(Bill) FROM `payment` WHERE `Date` BETWEEN ? AND ? ");
            preparedStatement.setString(1,start_date);
            preparedStatement.setString(2,end_date);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int bill = rs.getInt(1);
                textField3.setText(String.valueOf(bill));
            }
            preparedStatement.close();

        }catch (Exception x){
            JOptionPane.showMessageDialog(null," Have some Error !"+ x.getMessage());
        }
    }

    public Payment() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String ID = textField1.getText();

                    Connection con = Database.getConnection();
                    PreparedStatement preparedStatement = con.prepareStatement("SELECT `Vehicle Number`,`Bill`,`Service Type`,`Date` FROM `payment` WHERE `Service ID` = ?");
                    preparedStatement.setString(1,ID);
                    ResultSet rs = preparedStatement.executeQuery();

                    if (rs.next() == true){
                        String Vehicle_Number = rs.getString(1);
                        String Bill = rs.getString(2);
                        String Service_Type = rs.getString(3);
                        String Date = rs.getString(4);

                        textField2.setText(Vehicle_Number);
                        textField7.setText(Bill);
                        textField6.setText(Service_Type);
                        textField8.setText(Date);

                    }else{
                        textField1.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Service ID");
                    }
                    preparedStatement.close();

                }catch (Exception x){
                    JOptionPane.showMessageDialog(null," Have some Error !"+ x.getMessage());
                }
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start_date = textField4.getText();
                String end_date = textField5.getText();
                table(start_date,end_date);
                Bill(start_date,end_date);
            }
        });
        backToAdminPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPage A = new AdminPage();       // To show Admin page
                A.setContentPane(new AdminPage().AdminPage);
                A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                A.setVisible(true);
                A.pack();
            }
        });
    }
}
