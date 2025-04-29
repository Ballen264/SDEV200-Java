package com.personal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;

public class App extends Application {

    // Database connection.
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name"; // Database location.
    private static final String USERNAME = "your_username";         // Database Username
    private static final String PASSWORD = "your_password";         // Database Password

    // UI textfields.
    private TextField idField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField miField = new TextField();
    private TextField addressField = new TextField();
    private TextField cityField = new TextField();
    private TextField stateField = new TextField();
    private TextField telephoneField = new TextField();
    private TextField emailField = new TextField();

    // UI buttons.
    private Button viewButton = new Button("View");
    private Button insertButton = new Button("Insert");
    private Button updateButton = new Button("Update");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Gridpane grid = new GridPane();

        // UI suggested design elements.
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Placing labels/text fields on grid.
        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameField, 1, 1);

        grid.add(new Label("First Name:"), 0, 2);
        grid.add(firstNameField, 1, 2);

        grid.add(new Label("MI:"), 0, 3);
        grid.add(miField, 1, 3);

        grid.add(new Label("Address:"), 0, 4);
        grid.add(addressField, 1, 4);

        grid.add(new Label("City:"), 0, 5);
        grid.add(cityField, 1, 5);

        grid.add(new Label("State:"), 0, 6);
        grid.add(stateField, 1, 6);

        grid.add(new Label("Telephone:"), 0, 7);
        grid.add(telephoneField, 1, 7);

        grid.add(new Label("Email:"), 0, 8);
        grid.add(emailField, 1, 8);

        // Creating Hbox for buttons.
        HBox buttonBox = new HBox(10); // HBox is used for placing buttons horizontally, here I have given a spacing of 10 pixels.
        buttonBox.setAlignment(Pos.CENTER); // Aligning buttons to the center.
        buttonBox.getChildren().addAll(viewButton, insertButton, updateButton); // This should assist in creating buttons.
        grid.add(buttonBox, 0, 9, 2, 1); // This should span two columns, gotta double check logic.

        // Creates event handlers for buttons.
        viewButton.setOnAction(event -> viewStaff());
        insertButton.setOnAction(event ->insertStaff());
        updateButton.setOnAction(event -> updateStaff());

        // Settign up scene.
        Scene scene = new Scene(grid, 400, 400); // I believe this creates a 400 pixel by 400 pixel, using the grid as the content.
        primaryStage.setTitle("Staff Information"); // Sets the title of the window.
        primaryStage.setScene(scene); // Tells what scene object to display.
        primaryStage.show(); // Plays scene.
    }

    private void viewStaff() { // This class is ran when the display staff button is pressed.

        String id = idFields.getText(); // creates a personal ID object grabbed from idFields.

        if (id.isEmpty()) { // Checks if there are any objects inside of the id object.

            showAlert("Please enter an ID to view."); // Creates an alert window.
            return;

        } // This simply prevents breaking when there is an empty prompt.

        // Connects to the database, and pulls the specific information.
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Staff WHERE id = ?")) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // This line here pulls database information.

            if (resultSet.next()) { // This is a wierd line. resultSet.next() will cicle through the data returned by the executed SQL query.
                lastNameField.setText(resultSet.getString("LastName"));
                firstNameField.setText(resultSet.getString("FirstName"));
                miField.setText(resultSet.getString("mi"));
                addressField.setText(resultSet.getString("address"));
                cityField.setText(resultSet.getString("city"));
                stateField.setText(resultSet.getString("state"));
                telephoneField.setText(resultSet.getString("telephone"));
                emailField.setText(resultSet.getString("email"));
            } else {
                showAlert("Staff with ID " + id + " noit found."); // Creates an error window complaining about an invalid ID.
            }

        } catch (SQLEcveption e) { // Catches an error.
            e.printStackTrace(); // printStackTrace prints out detailed information about the caught error.
            showAlert("Databse error: " + e.getMessage()); // Creates error window.
        }

    }

    private void insertStaff() { // Used for the insertStaff button.

        // Private objects from the fields.
        String id = idField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String mi = miField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String telephone = telephoneField.getText();
        String email = emailField.getText();

        if (id.isEmpty() || lastName.isEmpty() || firstName.isEmpty()) { // An or statement checking if the ID, lastname, or first name are empty.
            
            showAlert("ID, last name, and first name required."); // New error message for missing inputs.
            return;

        }

        // Connects to the database again, inserting new lines.
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) { // SQL query inputted.

            // Updates the statement with following data.
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, mi);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, state);
            preparedStatement.setString(8, telephone);
            preparedStatement.setString(9, email);

        } catch (SQLException e) { // Catches exceptions.
            e.printStackTrace();
            showAlert("Database error; " + e.getMessage());
        }

    }

    private void updateStaff() { // Used for updateStaff button.

        // Private objects of fields.
        String id = idField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String mi = miField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String telephone = telephoneField.getText();
        String email = emailField.getText();

        if (id.isEmpty()) { // Creates error window complaining about empty ID.
            showAlert("Please enter the ID of the record to update.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? WHERE id = ?")) {

                // Updates the statement with following data.
                preparedStatement.setString(1, lastName);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, mi);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, city);
                preparedStatement.setString(6, state);
                preparedStatement.setString(7, telephone);
                preparedStatement.setString(8, email);
                preparedStatement.setString(9, id);

            } catch (SQLException e) {
                e.printStackTrace();showAlert("Database error: " + e.getMessage());
            }

    }

    private void showAlert(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType/INFORMATION); // This allows the code to create an error window using JavaFX.
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null); // Sets the headers text to null, being nothing.
        alert.setContentText(message);
        alert.showAndWait(); // Stops execution until user closes this window.
    }

    public static void main(String[] args) {
        launch(args);
    }

}

