import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Signup");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; add(userLabel, gbc);
        gbc.gridx = 1; add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(passLabel, gbc);
        gbc.gridx = 1; add(passField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(loginBtn, gbc);
        gbc.gridx = 1; add(signupBtn, gbc);

        setVisible(true);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (DataManager.users.containsKey(user) && DataManager.users.get(user).equals(pass)) {
                DataManager.currentUser = user;
                dispose();
                new MovieSelectionPage();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login.");
            }
        });

        signupBtn.addActionListener(e -> {
            dispose();
            new SignupPage();
        });
    }
}
