import java.awt.Color;
import javafx.application.Application; // Imports application code to run the application.
import javafx.scene.Scene; // This segment will be displayed.
import javafx.scene.layout.Pane; // Grants the pane pattern for presenting images.
import javafx.scene.paint.Color; // Allows for coloring the image.
import javafx.scene.shape.Circle; // This will be the button being used.
import javafx.stage.Stage;

public class CircleColorChanger extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Step 1 is creating a circle.
        Circle circle = new Circle(); // New circle.

        // Handlers for clicking the button and releasing the button.
        circle.setOnMousePressed(event -> { // Creates anonymous function for turning circle black.
            circle.setFill(Color.BLACK); // Changes circle attribute to be a filled color of black.
        });

        circle.setOnMouseReleased(event -> { // Creates anonymous function for turning circle white.
            circle.setFill(Color.WHITE); // Changes circle attribute to be a filled color of white.
        });

        // This creates the pane. Not very familiar with the pane, I assume it is used for setting up the scene.
        Pane root = new Pane(circle);

        // This creates the scene.
        Scene scene = new Scene(root);

        // This creates the stage title/scene.
        primaryStage.setTitle("Circle Color Changer"); // Application window title.
        primaryStage.setScene(scene);

        // Runs and shows stage.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Static method from javafx.application.Application class. Needed to run code.
    }

}

/*
 * There seems to be a problem with the javafx code.
 * I failed to figure out how to get that stuff running and this failed because of that.
 */