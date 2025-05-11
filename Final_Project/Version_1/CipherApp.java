/*
 * Main method, extending java.application.Application.
 * Uses JavaFX to present UI.
 * Recieves user input.
 * Creates EncodeMessage/DecodeMessage instances.
 * Displays results to user via JavaFX UI.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// Imports all javaFX required code.

public class CipherApp extends Application {

    private TextArea messageInput = new TextArea();
    private TextField hashInput = new TextField();
    private TextArea resultOutput = new TextArea();
    private RadioButton encodeRadio = new RadioButton("Encode");
    private RadioButton decodeRadio = new RadioButton("Decode");
    private Button processButton = new Button("Process");

    private EncodeMessage encoder = new EncodeMessage();
    private DecodeMessage decoder = new DecodeMessage();

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label messageLabel = new Label("Enter Message:");
        Label hashLabel = new Label("Enter Hash:");
        Label resultLabel = new Label("Result:");

        ToggleGroup cipherModeGroup = nwe ToggleGroup();
        encodeRadio.setToggleGroup(cipherModeGroup);
        decodeRadio.setToggleGroup(cipherModeGroup);
        encodeRadio.setSelected(true); // Defaults application to encoding.

        grid.add(new Label("Mode:"), 0, 0);
        grid.add(encodeRadio, 1, 0);
        grid.add(decodeRadio, 2, 0);
        
        grid.add(messageLabel, 0, 1);
        grid.add(messageInput, 1, 1, 2, 1); // This spans multiple columns.

        grid.add(hashLabel, 0, 2);
        grid.add(hashInput, 1, 2, 2, 1);

        grid.add(processButton, 1, 3, 2, 1);

        grid.add(resultLabel, 0, 4);
        grid.add(resultOutput, 1, 4, 2, 1); // This spans multiple columns.

        resultOutput.setEditale(false); // I don't want anyone messing with the output boxes.

        // These handle events.
        encodeRadio.setOnAction(event -> hashInput.setDisable(true));
        decodeRadio.setOnAction(event -> hashInput.setDisable(false));

        processButton.setOnAction(event-> {

            String message = messageInput.getText();

            if (encodeRadio.isSelected()) {

                String encoded = encoder.takeMessage(message);
                resultOutput.setText("Encoded: " + encoded);

            } else if (decodeRadio.isSelected()) {

                String hash = hashInput.getText();
                String decoded = decoder.takeMessage(message, hash);
                resultOutput.setText("Decoded: " + decoded);

            }

        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Cipher Program");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}