import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    JTextField user;
    JPasswordField pass;
    JButton login;
    JLabel status;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        user = new JTextField();
        pass = new JPasswordField();
        login = new JButton("Login");
        status = new JLabel("");

        add(new JLabel("Username:"));
        add(user);
        add(new JLabel("Password:"));
        add(pass);
        add(new JLabel(""));
        add(login);
        add(status);

        login.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String u = user.getText();
        String p = new String(pass.getPassword());

        if (u.equals("admin") && p.equals("1234"))
            status.setText("Login Successful!");
        else
            status.setText("Login Failed!");
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
