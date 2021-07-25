import com.test.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Service extends JFrame{
    public JPanel Service;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox <String>comboBox1;
    private JTextField textField7;
    private JTextField textField8;
    private JButton updateButton;
    private JButton addButton;
    private JComboBox <String>comboBox2;
    private JTextField textField9;
    private JButton deleteButton;
    private JTextField textField10;
    private JTextField textField11;
    private JButton backToAdminPageButton;
    public JLabel ImageLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLabel = new JLabel(new ImageIcon("pic6.jpg"));
    }

    public void ser_register(String Service_ID,String Vehicle_Number,String Model,String Model_Number,String Owner_NIC,String Owner_Name,String Date,String Service_Type,int Bill){
        try{
            Connection con = Database.getConnection();
            String sqlQuery = "INSERT INTO service VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String SQL = "INSERT INTO payment VALUES (NULL, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,Service_ID);
            preparedStatement.setString(2,Vehicle_Number);
            preparedStatement.setString(3,Model);
            preparedStatement.setString(4,Model_Number);
            preparedStatement.setString(5,Owner_NIC );
            preparedStatement.setString(6,Owner_Name);
            preparedStatement.setString(7,Date);
            preparedStatement.setString(8,Service_Type);
            preparedStatement.setString(9,String.valueOf(Bill));

            PreparedStatement preparedStatement1 = con.prepareStatement(SQL);
            preparedStatement1.setString(1,Service_ID);
            preparedStatement1.setString(2,Vehicle_Number);
            preparedStatement1.setString(3,String.valueOf(Bill));
            preparedStatement1.setString(4,Service_Type);
            preparedStatement1.setString(5,Date);

            try {
                preparedStatement.execute();
                preparedStatement1.execute();
                JOptionPane.showMessageDialog(null," Insert Data ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !  \n "+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error !!! \n "+  e.getMessage());
        }
    }

    public void update(int Bill, String Service_ID){
        try {
            Connection con = Database.getConnection();
            String sqlQuery = "UPDATE `service` SET `Bill Amount` = ? WHERE `Service ID` = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,String.valueOf(Bill));
            preparedStatement.setString(2,Service_ID);

            String SQL = "UPDATE `payment` SET `Bill` = ? WHERE `Service ID` = ?";

            PreparedStatement preparedStatement1 = con.prepareStatement(SQL);
            preparedStatement1.setString(1,String.valueOf(Bill));
            preparedStatement1.setString(2,Service_ID);

            try {
                preparedStatement.executeUpdate();
                preparedStatement1.executeUpdate();
                JOptionPane.showMessageDialog(null," Update Data !! ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !"+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error !!! \n"+ e.getMessage());
        }
    }
    public void Delete(String Service_ID){
        try {
            Connection con = Database.getConnection();
            String sqlQuery = "DELETE FROM `service` WHERE `Service ID` = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,Service_ID);

            try {
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null," Delete the row ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !"+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error !!! \n"+ e.getMessage());
        }
    }

    public Service() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Service_ID,Vehicle_Number,Model,Model_Number,Owner_NIC,Owner_Name,Date,Service_Type;
                int Bill;

                Service_ID = textField1.getText();
                Vehicle_Number = textField2.getText();
                Model = textField3.getText();
                Model_Number = textField4.getText();
                Owner_NIC = textField5.getText();
                Owner_Name = textField6.getText();
                Date = textField11.getText();
                Service_Type = comboBox1.getSelectedItem().toString();
                Bill = Integer.parseInt(textField10.getText());

                try {
                    if (Service_ID.equals("") && Vehicle_Number.equals("") && Model.equals("") && Model_Number.equals("") && Owner_NIC.equals("") && Owner_Name.equals("") && Date.equals("")&& Service_Type.equals("Select Fuel Type.")){
                        JOptionPane.showMessageDialog(null," Can not Inert data");
                    }else {
                        ser_register(Service_ID,Vehicle_Number,Model,Model_Number,Owner_NIC,Owner_Name,Date,Service_Type,Bill);
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
                textField11.setText("");
                comboBox1.setSelectedItem("Select Service Type");
                textField10.setText("");

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Service_ID;
                int Bill;

                Service_ID = textField7.getText();
                Bill = Integer.parseInt(textField8.getText());

                update(Bill,Service_ID);

                textField7.setText("");
                textField8.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Service_ID , Pay_the_Bill;

                Service_ID = textField9.getText();
                Pay_the_Bill = comboBox2.getSelectedItem().toString();

                if (Pay_the_Bill.equals("Yes")){
                    Delete(Service_ID);
                }else {
                    JOptionPane.showMessageDialog(null," This customer has not do payment then you can not delete this row");
                }
                textField9.setText("");
                comboBox2.setSelectedItem("Select you pay Bill.");

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
