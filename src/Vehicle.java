import com.test.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Vehicle extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JButton AddButton;
    private JButton Button2;
    public JPanel Vehicle;


    public void Veh_register(String V_num, String Ow_NIC, String Ow_Name, String V_model, String Model_num,String Fuel_Type){
        try{
            Connection con = Database.getConnection();
            String sqlQuery = "INSERT INTO vehicle VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,V_num);
            preparedStatement.setString(2,Ow_NIC);
            preparedStatement.setString(3,Ow_Name);
            preparedStatement.setString(4,V_model);
            preparedStatement.setString(5, Model_num);
            preparedStatement.setString(6,Fuel_Type);

            try {
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null," Insert Data ");

            }catch (Exception e){
                JOptionPane.showMessageDialog(null," Have some Error !  \n "+ e.getMessage());
            }
            con.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Oops !!!\n Have Some Error ! \n "+  e.getMessage());
        }
    }


    public Vehicle() {
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Vehicle_Number,Owner_NIC,Owner_name,Vehicle_Model,Model_Number,Fuel_Type;

                Vehicle_Number = textField1.getText();
                Owner_NIC = textField2.getText();
                Owner_name = textField3.getText();
                Vehicle_Model = textField4.getText();
                Model_Number = textField5.getText();
                Fuel_Type = comboBox1.getSelectedItem().toString();

                try {
                    if (Vehicle_Number.equals("") && Owner_NIC.equals("") && Owner_name.equals("") && Vehicle_Model.equals("") && Model_Number.equals("") && Fuel_Type.equals("Select Fuel Type.")){
                        JOptionPane.showMessageDialog(null," Can not enter data");
                    }else {
                        Veh_register(Vehicle_Number,Owner_NIC,Owner_name,Vehicle_Model,Model_Number,Fuel_Type);
                    }
                } catch (Exception x) {
                    System.out.println(x);;
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                comboBox1.setSelectedItem("Select Fuel Type.");;


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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

