import java.awt.Color;
import java.lang.reflect.GenericDeclaration;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// This program has two parts, requiring a lot more imports. I think this should be everything.

public class ColorMixer extends Application {

    private Rectange colorPreview; // Used for showign the preview for your selected colors.
    private Label rgbLabel; // Shows current RGB values.
    private Label opacityLabel; // Shows current opacity.
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double opacity = 1.0;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane(); // Formats the application into a grid pattern.
        grid.setAlignment(Pos.CENTER); // Aligns everything to the center.
        grid.setPadding(new Insets(20,20,20,20)); // Creates padding for the application elements.
        grid.setVgap(10); // Gap or extra padding.
        grid.setHgap(10); // Gap or extra padding.

        // Red scrollbar.
        Label redLabel = new Label("Red (0 - 255):");
        ScrollBar redScrollBar = new ScrollBar();
        redScrollBar.setMin(0);
        redScrollBar.setMax(255);
        redScrollBar.setValue(red);
        Label redValueLabel = new Label(String.valueOf(red));
        grid.Add(redLabel, 0, 0);
        grid.add(redScrollBar, 1, 0);
        grid.add(redValueLabel, 2, 0);

        // Green scrollbar.
        Label greenLabel = new Label("Green (0 - 255):");
        ScrollBar greenScrollBar = new ScrollBar();
        redScrollBar.setMin(0);
        redScrollBar.setMax(255);
        redScrollBar.setValue(green);
        Label greenValueLabel = new Label(String.valueOf(green));
        grid.Add(greenLabel, 0, 1);
        grid.add(greenScrollBar, 1, 1);
        grid.add(greenValueLabel, 2, 1);

        // Blue scrollbar.
        Label blueLabel = new Label("Blue (0 - 255):");
        ScrollBar blueScrollBar = new ScrollBar();
        blueScrollBar.setMin(0);
        blueScrollBar.setMax(255);
        blueScrollBar.setValue(blue);
        Label blueValueLabel = new Label(String.valueOf(blue));
        grid.Add(blueLabel, 0, 2);
        grid.add(blueScrollBar, 1, 2);
        grid.add(blueValueLabel, 2, 2);

        // Opacity scrollbar.
        Label opacityLabelText = new Label("Opacity (0% - 100%):");
        ScrollBar opacityScrollBar = new ScrollBar();
        opacityScrollBar.setMin(0);
        opacityScrollBar.setMax(100);
        opacityScrollBar.setValue(opacity * 100);
        Label opacityValueLabel = new Label(String.format("%.0f%%", opacity * 100));
        grid.Add(opacityLabelText, 0, 3);
        grid.add(opacityScrollBar, 1, 3);
        grid.add(opacityValueLabel, 2, 3);

        // Preview box.
        colorPreview = new Rectange(100,100);
        colorPreview.setStroke(Color.BLACK);
        updateColorPreview();
        grid.add(colorPreview, 0, 4, 3, 1); // I don't fully understand guide here.

        // Labels for RGB and Opacity.
        rgbLabel = new Label(String.format("RBG: (%d, %d, %d)", red, green, blue));
        opacityLabel = new Label(String.format("Opacity: %.2f", opacity));
        grid.add(rgbLabel, 0, 5, 3, 1); // I don't fully understand guide here.
        grid.add(opacityLabel, 0, 6, 3, 1); // I don't fully understand guide here.

        // Event Handlers for the scrollbars.
        // Insufficient understanding. This part has been ignored for now.

        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setTitle("Color Mixer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void updateColorPreview() { // Required for updating the image's color.
        Color color = Color.rgb(red, green, blue,opacity);
        colorPreview.setFill(color);
        rgbLabel.setText(String.format("RGB: (%d, %d, %d)", red, green, blue));
    }

    public static void main(String[] args) {
        launch(args); // Static method from javafx.application.Application class. Needed to run code.
    }

}

/*
 * There seems to be a problem with the javafx code.
 * I failed to figure out how to get that stuff running and this failed because of that.
 */