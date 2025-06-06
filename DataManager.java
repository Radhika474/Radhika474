import java.io.*;
import java.util.*;

public class DataManager {
    public static Map<String, String> users = new HashMap<>();
    public static Map<String, Set<String>> bookings = new HashMap<>();
    public static String currentUser = "";

    private static final String DATA_FILE = "data.dat";

    @SuppressWarnings("unchecked")
    public static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            users = (Map<String, String>) in.readObject();
            bookings = (Map<String, Set<String>>) in.readObject();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            users = new HashMap<>();
            bookings = new HashMap<>();
        }
    }

    public static void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(users);
            out.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
