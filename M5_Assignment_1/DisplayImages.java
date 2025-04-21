import javafx.application.Application; // Imports application code to run the application.
import javafx.scene.Scene; // This segment will be displayed.
import javafx.scene.image.Image; // Designates what type of thing is being presented.
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane; // Grants the grid pattern for presenting images.
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException; // This will be used for failing to locate the images.
import javax.swing.text.html.ImageView;

public class DisplayImages extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        String image1 = ".../Images/flag1.gif"; // String showing the gif location/
        String image2 = ".../Images/flag2.gif"; // String showing the gif location/
        String image3 = ".../Images/flag3.gif"; // String showing the gif location/
        String image4 = ".../Images/flag4.gif"; // String showing the gif location/
        
        ImageView imageView1 = createImageView(image1); // Creates the first image object from the file location.
        ImageView imageView2 = createImageView(image2); // Creates the second image object from the file location.
        ImageView imageView3 = createImageView(image3); // Creates the third image object from the file location.
        ImageView imageView4 = createImageView(image4); // Creates the fourth image object from the file location.
        
        GridPane root = new GridPane();
        root.setHgap(5); // This is the amount of pixels between each image horizontally.
        root.setVgap(5); // This is the amount of pixels between each image vertically.

        root.add(image1, 0, 0); // This will add an image to row 0, column 0.
        root.add(image1, 1, 0); // This will add an image to row 1, column 0.
        root.add(image1, 0, 1); // This will add an image to row 0, column 1.
        root.add(image1, 1, 1); // This will add an image to row 1, column 1.
        
        Scene scene = new Scene(root); // These set up the scene so that it is ready to be shown on the computer.
        primaryStage.setTitle("This displays the four flags.");
        primaryStage.setScene(scene);
        primaryStage.show(); // Crucial piece of code. Makes the window with the images show.
    }

    private ImageView createImageView(String imagePath) throws FileNotFoundException {
        FileInputStream inpputStream = new FileInputStream(imagePath);
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
        ImageView.setFitWidth(100);
        ImageView.setFitHeight(100);
        imageView.setPreverveRatio(true);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args); // Static method from javafx.application.Application class. Needed to run code.
    }

}

/*
 * There seems to be a problem with the javafx code.
 * I failed to figure out how to get that stuff running and this failed because of that.
 */