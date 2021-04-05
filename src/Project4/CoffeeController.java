package Project4;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static Project4.Main.currOrder;


/**
 * Controller class to give functionality to Coffee.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class CoffeeController {

    @FXML
    private Text coffeeText;

    @FXML
    private ImageView coffeImage;

    @FXML
    private CheckBox creamCheckboxOption, milkCheckboxOption, whippedCreamCheckboxOption, syrupCheckboxOption, caramelCheckboxOption;

    @FXML
    private ComboBox<String> sizeCombobox, quantityCombobox;

    @FXML
    private TextField totalTextArea;

    @FXML
    private Button addToOrderButton;



    private ObservableList<String> size = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
    private ObservableList<String> quantity = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    final static private double ROUNDER = 100.0;

    Coffee currCoffee = new Coffee();

    /**
     * Method to intialize items in GUI
     */
    public void initialize() {
        sizeCombobox.setItems(size);
        quantityCombobox.setItems(quantity);

        totalTextArea.setEditable(false);
        checkboxListeners();

    }

    /**
     *Helper method to count addins
     */
    public void checkboxListeners() {

       caramelCheckboxOption.selectedProperty().addListener(
               (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                   if(new_val){
                       currCoffee.newAddIn(caramelCheckboxOption.getText());
                   }else{
                       currCoffee.removeAddIn(caramelCheckboxOption.getText());
                   }
                   double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
                   totalTextArea.setText("$" + price);
               }
       );

        whippedCreamCheckboxOption.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if(new_val){
                        currCoffee.newAddIn(whippedCreamCheckboxOption.getText());
                    }else{
                        currCoffee.removeAddIn(whippedCreamCheckboxOption.getText());
                    }
                    double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
                    totalTextArea.setText("$" + price);
                }
        );

        milkCheckboxOption.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if(new_val){
                        currCoffee.newAddIn(milkCheckboxOption.getText());
                    }else{
                        currCoffee.removeAddIn(milkCheckboxOption.getText());
                    }
                    double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
                    totalTextArea.setText("$" + price);
                }
        );

        creamCheckboxOption.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if(new_val){
                        currCoffee.newAddIn(creamCheckboxOption.getText());
                    }else{
                        currCoffee.removeAddIn(creamCheckboxOption.getText());
                    }
                    double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
                    totalTextArea.setText("$" + price);
                }
        );

        syrupCheckboxOption.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if(new_val){
                        currCoffee.newAddIn(syrupCheckboxOption.getText());
                    }else{
                        currCoffee.removeAddIn(syrupCheckboxOption.getText());
                    }
                    double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
                    totalTextArea.setText("$" + price);
                }
        );

    }

    /**
     * Method to calculate subtotal of coffee
     */
    @FXML
    public void calculateTotal(){

        if(sizeCombobox.getValue() != null && quantityCombobox.getValue() != null) {
            currCoffee.setSize(sizeCombobox.getValue());
            currCoffee.setQuantity(Integer.parseInt(quantityCombobox.getValue()));

            double price = Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER;
            String result = "$" + price;

            totalTextArea.setText(result);
        }

    }

    /**
     * Method to add items to order
     */
    @FXML
    void addToOrder() {
        if(sizeCombobox.getValue() != null && quantityCombobox.getValue() != null) {
            currOrder.add(currCoffee);
            currOrder.setSubTotal(Math.round(currCoffee.itemPrice() * ROUNDER) / ROUNDER);
            currOrder.setSalesTax();
            currOrder.setTotal();
            Stage stage=(Stage) addToOrderButton.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Order has been added!");
            alert.showAndWait();
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Input size and quantity!");
            alert.showAndWait();
        }

    }

}
