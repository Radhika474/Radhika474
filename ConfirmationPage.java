import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class ConfirmationPage extends JFrame {
    public ConfirmationPage(String movie, Set<String> seats) {
        setTitle("Booking Confirmed");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Booking Confirmation",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            Color.BLACK
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        String username = DataManager.currentUser;
        int amount = seats.size() * 150;

        JLabel headingLabel = new JLabel("Booking Confirmed");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel userLabel = new JLabel("User: " + username);
        JLabel movieLabel = new JLabel("Movie: " + movie);
        JLabel seatsLabel = new JLabel("Seats: " + String.join(", ", seats));
        JLabel amountLabel = new JLabel("Total Paid: ?" + amount);
        JLabel confirmLabel = new JLabel("Your booking is confirmed!");

        // Set all fonts to bold
        Font boldFont = new Font("Arial", Font.BOLD, 16);
        userLabel.setFont(boldFont);
        movieLabel.setFont(boldFont);
        seatsLabel.setFont(boldFont);
        amountLabel.setFont(boldFont);
        confirmLabel.setFont(boldFont);

        JButton bookAgainBtn = new JButton("Book Another Ticket");
        JButton exitBtn = new JButton("Exit");

        bookAgainBtn.setFont(new Font("Arial", Font.BOLD, 14));
        exitBtn.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headingLabel, gbc);

        gbc.gridy++;
        panel.add(userLabel, gbc);

        gbc.gridy++;
        panel.add(movieLabel, gbc);

        gbc.gridy++;
        panel.add(seatsLabel, gbc);

        gbc.gridy++;
        panel.add(amountLabel, gbc);

        gbc.gridy++;
        panel.add(confirmLabel, gbc);

        gbc.gridy++;
        panel.add(bookAgainBtn, gbc);

        gbc.gridy++;
        panel.add(exitBtn, gbc);

        add(panel);
        setVisible(true);

        bookAgainBtn.addActionListener(e -> {
            dispose();
            new MovieSelectionPage();
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }
}
