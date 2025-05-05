import java.lang.classfile.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox; // Using a vertical box layout for the application.
import javafx.stage.Stage;
import javax.swing.RootPaneContainer;

public class LoanCalculator extends Application { // Main class holding code.

    private TextField loanAmountField = new TextField();
    private TextField annualInterestRateField = new TextField();
    private TextField numberOfYearsField = new TextField();
    private Label monthlyPaymentLabel = new Label();
    private Label totalPaymentLabel = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception { // throws exception is a failsafe for crashing code and errors.

        // Creating Labels for user input.
        Label loanAmountLabel = new Label("Loan Amount: ");
        label annualInterestRateLabel = new Label("Annual Interest Rate: ");
        Label numberOfYearsLabel = new Label("Number of Years: ");

        // Creating Buttons for user to interact with progam.
        Button computeButton = new Button("Compute Loan Payment");
        Button resetButton = new Button("Reset");

        // Set empty prompt text for labels when empty.
        loanAmountField.setPromptText("Enter loan amount");
        annualInterestRateField.setPromptText("Enter annual interest rate");
        numberOfYearsField.setPromptText("Enter number of years");

        root.getChildren().addAll( // Adds several elements to the root to be formatted in the application.
            loanAmountLabel, loanAmountField,
            annualInterestRateLabel, annualInterestRateField,
            numberOfYearsLabel, numberOfYearsField,
            new Label(), new Label(), // This line creates empty space between the text boxes and the user buttons.
            computeButton,
            resetButton,
            monthlyPaymentLabel,
            totalPaymentLabel
        );

        // Compute button "event handler."
        computeButton.setOnAction(event -> computeLoanPayment());
        
        // Reset button "event handler."
        resetButton.setOnAction(event -> resetCalculator());

        // Creates scene and sets stage.
        Scene scene = new Scene(root, 300, 400); // I think this size should be fine?
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void computeLoanPayment() {
        try {
            double loanAmount = Double.parseDouble(loanAmountField.getText()); // Establishes a double value of the loan amount to be computed.
            double annualInterestRate = Double.parseDouble(annualInterestRateField.getText()); // Establishes a double value of the annual interest rate to be computed.
            int numberOfYears = Integer.parseInt(numberOfYearsField.getText()); // Establishes an int value of the number of years to be computed.

            // Creates Loan class instance to compute payment.
            Loan loan = new Loan(loanAmount, annualInterestRate, numberOfYears);
            double monthlyPayment = loan.getMonthlyPayment();
            double totalPayment = loan.getTotalPayment();

            // Reformats/displays computed numbers.
            monthlyPaymentLabel.setText(String.format("Monthly Payment: $%.2f", monthlyPayment)); // I never would have gotten the $%.2f part by myself, though I do have past experience from it.
            totalPaymentLabel.setText(String.format("Toal Payment: $%.2f", totalPayment)); // %.2f allows for the string to insert a number going down to 2 decimal places.

        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numbers in all text boxes.");
        } catch (IllegalArgumentException e) {
            showAlert("Invalid Input", e.getMessage()); // This will present any actual problems that the code ran into.
        }
    }

    private void resetCalculator() { // This just clears all fields.
        loanAmountField.clear();
        annualInterestRateField.clear();
        numberOfYearsField.clear();
        monthlyPaymentLabel.setText("");
        totalPaymentLabel.setText("");
    }

    private void showAlert(String title, String content) { // Handles the code showing an error window.
        // I'm bound to botch one of these lines, I hate stuff like this.
        // There must be a better way to handle this, right?
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) { // Runs code.
        launch(args);
    }
}