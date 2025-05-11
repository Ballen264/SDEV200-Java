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
    // These are creating the buttons that the code will use.

    private EncodeMessage encoder = new EncodeMessage();
    private DecodeMessage decoder = new DecodeMessage();
    // This is setting up new values for presenting the encoded and decoded messages.

    @Override
    public void start(Stage primaryStage) { // Class for the stage.

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        // Stage settings.

        Label messageLabel = new Label("Enter Message:");
        Label hashLabel = new Label("Enter Hash:");
        Label resultLabel = new Label("Result:");
        // This is creating new labels.
        // messageLabel is used for entering a new message, whether it needs to be encoded or decoded doesn't matter.
        // hashLabel will be integrated shortly.

        ToggleGroup cipherModeGroup = nwe ToggleGroup();
        encodeRadio.setToggleGroup(cipherModeGroup);
        decodeRadio.setToggleGroup(cipherModeGroup);
        encodeRadio.setSelected(true); // Defaults application to encoding.

        grid.add(new Label("Mode:"), 0, 0);
        grid.add(encodeRadio, 1, 0);
        grid.add(decodeRadio, 2, 0);
        // This code is applying the UI elements to the applicaiton.
        
        grid.add(messageLabel, 0, 1);
        grid.add(messageInput, 1, 1, 2, 1); // This spans multiple columns.
        // This code is applying the UI elements to the applicaiton.

        grid.add(hashLabel, 0, 2);
        grid.add(hashInput, 1, 2, 2, 1);
        // This code is applying the UI elements to the applicaiton.

        grid.add(processButton, 1, 3, 2, 1);
        // This code is applying the UI elements to the applicaiton.

        grid.add(resultLabel, 0, 4);
        grid.add(resultOutput, 1, 4, 2, 1); // This spans multiple columns.
        // This code is applying the UI elements to the applicaiton.

        resultOutput.setEditale(false); // I don't want anyone messing with the output boxes.

        // These handle events.
        encodeRadio.setOnAction(event -> hashInput.setDisable(true));
        decodeRadio.setOnAction(event -> hashInput.setDisable(false));

        processButton.setOnAction(event-> {

            String message = messageInput.getText();

            if (encodeRadio.isSelected()) {

                String encoded = encoder.takeMessage(message);
                resultOutput.setText("Encoded: " + encoded);
                // This code handles the user selecting the encoder and changes the resultOutput text.

            } else if (decodeRadio.isSelected()) {

                String hash = hashInput.getText();
                String decoded = decoder.takeMessage(message, hash);
                resultOutput.setText("Decoded: " + decoded);
                // This code handles the user selecting the decoder and changes the resultOutput text.

            }

        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Cipher Program");
        primaryStage.setScene(scene);
        primaryStage.show();
        // Sets the scene.

    }

    public static void main(String[] args) {
        launch(args);
        // Runs args.
    }

}