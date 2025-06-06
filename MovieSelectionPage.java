import javax.swing.*;
import java.awt.*;

public class MovieSelectionPage extends JFrame {
    public MovieSelectionPage() {
        setTitle("Select Movie");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        String[] movies = {
            "Bhaahubali",
            "KGF",
            "Interstellar",
            "The Dark Knight",
            "Parasite"
        };

        String[] times = {
            "7:00 AM",
            "1:00 PM",
            "4:00 PM",
            "7:00 PM"
        };

        String[] theaters = {
            "PVR Cinemas",
            "Bharath Cinemas",
            "INOX",
            "Cinepolies",
            "Cini Galaxy"
        };

        JComboBox<String> movieBox = new JComboBox<>(movies);
        JComboBox<String> timeBox = new JComboBox<>(times);
        JComboBox<String> theaterBox = new JComboBox<>(theaters);
        JTextArea descriptionArea = new JTextArea(4, 30);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);

        JButton nextBtn = new JButton("Next");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Select Movie:"), gbc);
        gbc.gridx = 1;
        panel.add(movieBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Select Time:"), gbc);
        gbc.gridx = 1;
        panel.add(timeBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Select Theater:"), gbc);
        gbc.gridx = 1;
        panel.add(theaterBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Movie Description:"), gbc);
        gbc.gridx = 1;
        panel.add(new JScrollPane(descriptionArea), gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(nextBtn, gbc);

        add(panel);
        setVisible(true);

        movieBox.addActionListener(e -> {
            String selectedMovie = (String) movieBox.getSelectedItem();
            switch (selectedMovie) {
                case "Bhaahubali":
                    descriptionArea.setText("An epic action-packed tale of love, betrayal, and war.");
                    break;
                case "KGF":
                    descriptionArea.setText("A gangster saga set in the gold mines of Kolar.");
                    break;
                case "Interstellar":
                    descriptionArea.setText("Astronauts explore a wormhole in search of a new home for humanity.");
                    break;
                case "The Dark Knight":
                    descriptionArea.setText("Batman faces the Joker in one of the best superhero films ever.");
                    break;
                case "Parasite":
                    descriptionArea.setText("A poor family infiltrates a wealthy household in this dark comedy thriller.");
                    break;
                default:
                    descriptionArea.setText("");
            }
        });

        nextBtn.addActionListener(e -> {
            String movie = (String) movieBox.getSelectedItem();
            String time = (String) timeBox.getSelectedItem();
            String theater = (String) theaterBox.getSelectedItem();

            if (movie != null && time != null && theater != null) {
                String movieInfo = movie + " - " + time + " @ " + theater;
                dispose();
                new SeatBookingPage(movieInfo);
            } else {
                JOptionPane.showMessageDialog(this, "Please select all options.");
            }
        });
    }
}
