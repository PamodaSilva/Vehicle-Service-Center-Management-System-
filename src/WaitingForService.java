import com.test.Database;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WaitingForService extends JFrame{
    public JPanel WaitForService;
    private JButton searchButton;
    private JButton backToAdminPageButton;
    private JTable table1;
    private JScrollPane table_1;
    public JLabel ImageLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLabel = new JLabel(new ImageIcon("pic8.jpg"));
    }

    public void connect() {
        try {
            Connection con = Database.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `service`");
            ResultSet rs = preparedStatement.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null," Have some Error !"+ e.getMessage());
        }
    }

    public WaitingForService() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect();
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
