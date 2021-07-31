import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel main;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;

    // Encapsulation..
    private String username;
    private char[] password;

    public String getUsername(){
        username = textField1.getText();
        return username;
    }
    public String getPassword(){
        password = passwordField1.getPassword();
        String pass = new String(password); // convert to string value
        return pass;
    } //....

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getUsername().equals("Admin") && getPassword().equals("admin123")){
                    JOptionPane.showMessageDialog(null," Login Success !!! "); // Message Box

                    AdminPage A = new AdminPage();       // To show Admin page
                    A.setContentPane(new AdminPage().AdminPage);
                    A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    A.pack();
                    A.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, " Invalid Login \n Username or Password Incorrect"); // Message box
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Vehicle Center Management System ");
        frame.setContentPane(new Login().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}