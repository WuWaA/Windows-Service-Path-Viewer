import javafx.application.*;
import javafx.stage.*;

public class ServicePathViewer extends Application {
    View view;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        // stage.setWidth(800);
        // stage.setHeight(600);
        this.view = new View(stage);
    }
}