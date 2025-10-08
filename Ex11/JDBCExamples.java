package jdbcexamples;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExamples {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection conn;
    public static class User {
        private int id;
        private String username;
        private String password;
        private String email;
        public User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.email = email;
        }
        @Override
        public String toString() {
            return "User{" + "id=" + id + ", username='" + username + '\'' +
                    ", password='" + password + '\'' + ", email='" + email + '\'' + '}';
        }
    }
    public JDBCExamples() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public boolean addUser(String username, String password, String email) {
        String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Add user error: " + e.getMessage());
            return false;
        }
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("Get all users error: " + e.getMessage());
        }
        return users;
    }
    public User getUserById(int id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Get user by ID error: " + e.getMessage());
        }
        return null;
    }
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Get user by username error: " + e.getMessage());
        }
        return null;
    }
    public boolean updateUser(int id, String newPassword, String newEmail) {
        String sql = "UPDATE Users SET password = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            ps.setString(2, newEmail);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update user error: " + e.getMessage());
            return false;
        }
    }
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = " + id;
        try (Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            System.out.println("Delete user error: " + e.getMessage());
            return false;
        }
    }
    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
    public static void main(String[] args) {
        try {
            JDBCExamples app = new JDBCExamples();
            app.addUser("john", "pass123", "john@example.com");
            app.addUser("jane", "pass456", "jane@example.com");
            System.out.println("All users:");
            for (User u : app.getAllUsers()) {
                System.out.println(u);
            }
            System.out.println("\nUser with ID=1:");
            System.out.println(app.getUserById(1));
            System.out.println("\nUser with username 'jane':");
            System.out.println(app.getUserByUsername("jane"));
            boolean updated = app.updateUser(1, "newpass123", "john_new@example.com");
            System.out.println("\nUpdate user ID=1: " + (updated ? "Success" : "Failed"));
            System.out.println(app.getUserById(1));
            boolean deleted = app.deleteUser(2);
            System.out.println("\nDelete user ID=2: " + (deleted ? "Success" : "Failed"));
            System.out.println("\nUsers after deletion:");
            for (User u : app.getAllUsers()) {
                System.out.println(u);
            }
            app.close();
        } catch (SQLException e) {
        }
    }
}
