import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class PaymentPage extends JFrame {
    public PaymentPage(String movie, Set<String> seats) {
        setTitle("Payment");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Proceed to Payment to Confirm Your Seat",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            Color.BLACK
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        String username = DataManager.currentUser;
        int totalAmount = seats.size() * 150;

        JLabel userLabel = new JLabel("Username: " + username);
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel totalLabel = new JLabel("Amount to Pay: ?" + totalAmount);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton payBtn = new JButton("Pay Now");
        payBtn.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(userLabel, gbc);

        gbc.gridy++;
        panel.add(totalLabel, gbc);

        gbc.gridy++;
        panel.add(payBtn, gbc);

        add(panel);
        setVisible(true);

        payBtn.addActionListener(e -> {

            String key = DataManager.currentUser + "-" + movie;
            DataManager.bookings.put(key, seats);
            DataManager.saveData();

            JOptionPane.showMessageDialog(this, "Payment successful! Booking confirmed.");
            dispose();
            new ConfirmationPage(movie, seats);
        });
    }
}

