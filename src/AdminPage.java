import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    public JPanel AdminPage;
    private JButton customerButton;
    private JButton vehicleButton;
    private JButton serviceButton;
    private JButton paymentButton;
    private JButton WaitingForServiceButton;
    public JLabel ImageLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLabel = new JLabel(new ImageIcon("pic2.jpg"));
    }

    public AdminPage() {
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cus = new Customer();       // To show Customer page
                cus.setContentPane(new Customer().Customer);
                cus.setPreferredSize(new Dimension(600,550));
                cus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cus.pack();
                cus.setVisible(true);


            }
        });
        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle v = new Vehicle();       // To show vehicle page
                v.setContentPane(new Vehicle().Vehicle);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                v.pack();
                v.setVisible(true);

            }
        });
        serviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Service Ser = new Service();       // To show service page
                Ser.setContentPane(new Service().Service);
                Ser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Ser.pack();
                Ser.setVisible(true);


            }
        });
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment pay = new Payment();  // To show payment page
                pay.setContentPane(new Payment().Payment);
                pay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pay.pack();
                pay.setVisible(true);


            }
        });
        WaitingForServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaitingForService WFS = new WaitingForService();  // To show Waiting For Service page
                WFS.setContentPane(new WaitingForService().WaitForService);
                WFS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                WFS.pack();
                WFS.setVisible(true);


            }
        });
    }

    public static void main(String[] args) {
        AdminPage A = new AdminPage();       // To show Admin page
        A.setContentPane(new AdminPage().AdminPage);
        A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        A.pack();
        A.setVisible(true);

    }


}
