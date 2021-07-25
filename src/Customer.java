import com.test.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Customer extends JFrame{
    public JPanel Customer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton addButton;
    private JButton Button2;
    public JLabel ImageLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLabel = new JLabel(new ImageIcon("pic3.jpg"));
    }

    public void register(String NIC, String Cus_Name, String Address, String TPHome, String TPMobile, String Email_add) {
        try{
            Connection con = Database.getConnection();
            String sqlQuery = "INSERT INTO customer (NIC,Name,Address,TPHome,TPMobile,Email)VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,NIC);
            preparedStatement.setString(2,Cus_Name);
            preparedStatement.setString(3,Address);
            preparedStatement.setString(4,TPHome);
            preparedStatement.setString(5, TPMobile);
            preparedStatement.setString(6,Email_add);

            try {
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null," Insert Data ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !"+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error !!! \n "+ e.getMessage());
        }
    }

    public Customer() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NIC,Name,Address,TPHome,TPMobile,Email;

                NIC = textField1.getText();
                Name = textField2.getText();
                Address = textField3.getText();
                TPHome = textField4.getText();
                TPMobile = textField5.getText();
                Email = textField6.getText();

                try {
                    if (NIC.equals("") && Name.equals("") && Address.equals("") && TPHome.equals("") && TPMobile.equals("") && Email.equals("")){
                        JOptionPane.showMessageDialog(null," You Can not Insert data");
                    }else {
                        register(NIC,Name,Address,TPHome,TPMobile,Email);
                    }
                } catch (Exception x) {
                    System.out.println(x);
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");

            }
        });
        Button2.addActionListener(new ActionListener() {
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
