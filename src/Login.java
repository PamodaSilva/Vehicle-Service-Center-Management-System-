import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel main;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                char[] password = passwordField1.getPassword();
                String pass = new String(password); // convert to string value

                if (username.equals("Admin") && pass.equals("123")){
                    JOptionPane.showMessageDialog(null," Login Success "); // Message Box

                    AdminPage A = new AdminPage();       // To show Admin page
                    A.setContentPane(new AdminPage().AdminPage);
                    A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    A.pack();
                    A.setVisible(true);



                }else {
                    JOptionPane.showMessageDialog(null, " Invalid Login "); // Message box
                }

            }
        });
    }

    public static void main(String[] args) {
        Login log = new Login();
        log.setContentPane(new Login().main);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setVisible(true);
        log.pack();

    }
}