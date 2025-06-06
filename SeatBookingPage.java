import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SeatBookingPage extends JFrame {
    private Set<String> selected = new HashSet<>();

    public SeatBookingPage(String movie) {
        setTitle("Select Seats - " + movie);
        setLayout(new BorderLayout());

        JPanel seatPanel = new JPanel(new GridLayout(5, 6, 5, 5));
        Set<String> allBooked = new HashSet<>();
        for (String key : DataManager.bookings.keySet()) {
            if (key.endsWith(movie)) {
                allBooked.addAll(DataManager.bookings.get(key));
            }
        }

        for (int i = 1; i <= 30; i++) {
            String seat = "S" + i;
            JButton btn = new JButton(seat);
            if (allBooked.contains(seat)) {
                btn.setBackground(Color.RED);
                btn.setEnabled(false);
            } else {
                btn.setBackground(Color.GREEN);
                btn.addActionListener(e -> {
                    if (selected.contains(seat)) {
                        selected.remove(seat);
                        btn.setBackground(Color.GREEN);
                    } else {
                        selected.add(seat);
                        btn.setBackground(Color.YELLOW);
                    }
                });
            }
            seatPanel.add(btn);
        }

        JButton bookBtn = new JButton("Book");
        bookBtn.addActionListener(e -> {
            if (selected.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select at least one seat.");
                return;
            }
            dispose();
            new PaymentPage(movie, selected); // ? Pass to PaymentPage to confirm and save
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(bookBtn);

        add(seatPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
