package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.text.Text;

/**
 * Controller class to give functionality to Main.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class MainController {

    @FXML
    private Button orderDonutsButton, orderCoffeeButton, yourOrderButton, storeOrderButton;

    @FXML
    private Text cafeTitleText;

    /**
     * Method to start up Coffeee GUI
     */
    @FXML
    void openOrderCoffee() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Coffee.fxml"));
            Scene scene = new Scene(loader.load(), 500, 470);
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Coffee.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to open Donut GUI
     */
    @FXML
    void openOrderDonuts() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Donut.fxml"));
            Scene scene = new Scene(loader.load(), 520, 456);
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Donut.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to open Store Orders GUI
     */
    @FXML
    void openStoreOrder() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StoreOrder.fxml"));
            Scene scene = new Scene(loader.load(), 370, 400);
            Stage stage = new Stage();
            stage.setTitle("Store Order");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to open Your Orders GUI
     */
    @FXML
    void openYourOrder() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Order.fxml"));
            Scene scene = new Scene(loader.load(), 450, 400);
            Stage stage = new Stage();
            stage.setTitle("Your Order");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
