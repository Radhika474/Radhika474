import java.io.*;
import java.util.HashMap;

public class Auth {
    private static final String FILE_NAME = "users.dat";
    protected static HashMap<String, User> userDB = loadUsers();

    @SuppressWarnings("unchecked")
    private static HashMap<String, User> loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<String, User>) in.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    private static void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(userDB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Register a new user
    public static boolean register(String username, String password) {
        if (userDB.containsKey(username)) return false;
        userDB.put(username, new User(username, password));
        saveUsers();
        return true;
    }

    // Login and return the User object
    public static User login(String username, String password) {
        User user = userDB.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Save changes to a specific user (after booking or update)
    public static void saveCurrentUser(User user) {
        userDB.put(user.getUsername(), user);
        saveUsers();
    }

    // Get all users (for admin or debug purposes)
    public static HashMap<String, User> getAllUsers() {
        return userDB;
    }
}
