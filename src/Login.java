import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel main;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    public JLabel ImageLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLabel = new JLabel(new ImageIcon("pic1.jpg"));
    }

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                char[] password = passwordField1.getPassword();
                String pass = new String(password); // convert to string value

                if (username.equals("Admin") && pass.equals("123")){
                    JOptionPane.showMessageDialog(null," Login Success !!! "); // Message Box

                    AdminPage A = new AdminPage();       // To show Admin page
                    A.setContentPane(new AdminPage().AdminPage);
                    A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    A.pack();
                    A.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, " Invalid Login , Username or Password Incorrect"); // Message box
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Login().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}