import javafx.application.Application;
import javafx.stage.Stage;

public class StudentApp extends Application {

    // main() – Program entry point (Module 1)
    public static void main(String[] args) {
        launch(args);   // Start JavaFX application
    }

    // start() – Called when JavaFX application starts (Module 5)
    @Override
    public void start(Stage primaryStage) {
        MainWindow main = new MainWindow(); // Create main window object
        main.show(primaryStage);            // Display it
    }
}
