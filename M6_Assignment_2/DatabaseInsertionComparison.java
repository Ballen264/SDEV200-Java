import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;
// Imports.

public class DatabaseInsertionComparison {

    private static final String DB_RUL = "jdbc:mysql://localhost:3306/unused_database_name"; // Fix String to correct database URL.
    private static final String DB_USER = "username"; // Fix String to correct username.
    private static final String DB_PASSWORD = "password"; // Fix String to correct password.
    private static final int NUM_RECORDS = 1000; // Quantity of items being inserted into database.

    // Basic DBConnectionPanel, might be replaced by textbook panel if I can figure it out.
    static class DBConnectionPanel extends JPanel {

        JTextField urlField = new JTextField(DB_URL, 30);
        JTextField userField = new JTextField(DB_USER, 20);
        JPasswordField passwordField = new JPasswordField(DB_PASSWORD, 20);

        public DBConnectionPanel() {
            setLayout(new GridLayout(3, 2));
            add(new JLabel("Database URL:"));
            add(urlField);
            add(new JLabel("Username:"));
            add(userField);
            add(new JLabel("Password:"));
            add(passwordField);

        }

        // Get methods for grabbing data.
        public String getURL() {
            return urlField.getText();
        }
        public String getUser() {
            return userField.getText();
        }
        public String getPassword() {
            return new String(passwordField.getPassword());
        }

        // Main.
        public static void main(String[] args) {
            
            // Creating and showing DB connection dialog. This I believe is shown in example images.
            DBConnectionPanel connectionPanel = new DBConnectionPanel();
            int result = JOptionPane.showConfirmDialog(
                null, connectionPanel, "Database Connection Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            // Connecting to the database.
            if (result == JOptionPane.OK_OPTION) {

                String dbUrl = connectionPanel.getUrl();
                String dbUser = connectionPanel.getUser();
                String dbPassword = connectionPanel.getPassword();

                compareInsertionPerformance(dbUrl, dbUser, dbPassword);

            } else { // Text showing that connection is canceled.

                System.out.println("Database connection canceleed.");

            }

            // Exits the system.
            System.exit(0);

        }

        // Method being called for database connection.
        public static void compareInsertionPerformance(String dbUrl, String dbUser, String dbPassword) {

            Random random = new Random();

            // Inserting without batch updates.
            long startTimeIndividual = System.nanoTime(); // This allows the code to count how long it is running to do a task.

            try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)")) {

                connection.setAutoCommit(true); // Individual commits.

                for (int i = 0; i < NUM_RECORDS; i++) {
                    
                    statement.setDouble(1, random.nextDouble());
                    statement.setDouble(2, random.nextDouble());
                    statement.setDouble(3, random.nextDouble());
                    statement.executeUpdate();

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

            // Calculates run time of task.
            long endTime Individual = System.nanoTime();
            long durationIndividual = (undTimeIndividual - startTimeIndividual) / 1_000_000;
            System.out.println("Inserted " + NUM_RECORDS + " records individully in: " + durationIndividual + " ms.");

            // Inserting with batch updates.
            long startTimeBatch = System.nanoTime();

            try (Connection connection = DriverManager.getConnection(dbRul, dbUser, dbPassword);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)")) {
                
                connection.setAutoCommit(false); // Prevents auto-commit from batching.

                for (int i = 0; i < NUM_RECORDS; i++) {

                    statement.setDouble(1, random.nextDouble());
                    statement.setDouble(2, random.nextDouble());
                    statement.setDouble(3, random.nextDouble());
                    statement.addBatch();

                }
                
                statement.executeBatch();
                connection.commit(); // Commits entire batch at once.

            } catch (SQLEcveption e) {

                e.printStackTrace();

            }

            // Calculates task time.
            long endTimeBatch = System.nanoTime();
            long durationBatch = (endTimeBatch - startTimeBatch) / 1_000_000;
            System.out.println("Inserted " + NUM_RECORDS + " records using batch updates in: " + durationBatch + " ms.");

        }

    }

}