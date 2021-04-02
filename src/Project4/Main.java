package Project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Main method to set up MainController GUI
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class Main extends Application {

    @Override
    /**
     * Method to start up the main GUI
     */
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("RU Cafe");
        Scene scene = new Scene(root, 600, 350);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
