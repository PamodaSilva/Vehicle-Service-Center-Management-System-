import com.test.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Service extends JFrame {
    public JPanel Service;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JTextField textField7;
    private JTextField textField8;
    private JButton updateButton;
    private JButton addButton;
    private JComboBox comboBox2;
    private JTextField textField9;
    private JButton deleteButton;
    private JTextField textField10;
    private JTextField textField11;
    private JButton backToAdminPageButton;

    public void ser_register(String Service_ID,String Vehicle_Number,String Model,String Model_Number,String Owner_NIC,String Owner_Name,String Date,String Service_Type,int Bill){
        try{
            Connection con = Database.getConnection();
            String sqlQuery = "INSERT INTO service VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String SQL = "INSERT INTO payment VALUES (NULL, ?, ?, ?, ?)";

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
            preparedStatement1.setString(4,Date);

            try {
                preparedStatement.execute();
                preparedStatement1.execute();
                JOptionPane.showMessageDialog(null," Insert Data ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !  \n "+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Oops !!!\n Have Some Error !! \n "+  e.getMessage());
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
    }
}
