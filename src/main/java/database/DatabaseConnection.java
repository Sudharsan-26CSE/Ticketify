package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Fetch the secure variables from environment (Render)
    private static final String URL = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:h2:mem:train_db;DB_CLOSE_DELAY=-1;MODE=MySQL";
    private static final String USER = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "sa";
    private static final String PASS = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.h2.Driver");
                // Connect using those variables
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Database connected successfully: " + URL);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
        return connection;
    }
}
