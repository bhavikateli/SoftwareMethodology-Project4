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
    private Button orderDonutsButton;

    @FXML
    private Button orderCoffeeButton;

    @FXML
    private Button yourOrderButton;

    @FXML
    private Button storeOrderButton;

    @FXML
    private Text cafeTitleText;

    @FXML
    void openOrderCoffee() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OrderCoffee.fxml"));
            Scene scene = new Scene(loader.load(), 500, 470);
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Coffee.css").toExternalForm());
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openOrderDonuts() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OrderDonut.fxml"));
            Scene scene = new Scene(loader.load(), 450, 430);
            Stage stage = new Stage();
            stage.setTitle("Order Donuts");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("Donut.css").toExternalForm());
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openStoreOrder() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StoreOrder.fxml"));
            Scene scene = new Scene(loader.load(), 370, 400);
            Stage stage = new Stage();
            stage.setTitle("Store Order");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openYourOrder() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("YourOrder.fxml"));
            Scene scene = new Scene(loader.load(), 450, 400);
            Stage stage = new Stage();
            stage.setTitle("Your Order");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
