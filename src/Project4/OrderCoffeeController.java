package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * Controller class to give functionality to OrderCoffee.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class OrderCoffeeController {

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

    }

    /**
     *
     */
    public void checkboxListeners() {

        if (caramelCheckboxOption.isSelected() == true) {
            currCoffee.newAddIn(caramelCheckboxOption.getText());
        } else if (creamCheckboxOption.isSelected() == true) {
            currCoffee.newAddIn(creamCheckboxOption.getText());
        } else if (milkCheckboxOption.isSelected() == true) {
            currCoffee.newAddIn(milkCheckboxOption.getText());
        } else if (syrupCheckboxOption.isSelected() == true) {
            currCoffee.newAddIn(syrupCheckboxOption.getText());
        } else if (whippedCreamCheckboxOption.isSelected() == true) {
            currCoffee.newAddIn(whippedCreamCheckboxOption.getText());
        } else if (caramelCheckboxOption.isSelected() != true) {
            currCoffee.removeAddIn(caramelCheckboxOption.getText());
        } else if (creamCheckboxOption.isSelected() != true) {
            currCoffee.removeAddIn(creamCheckboxOption.getText());
        } else if (milkCheckboxOption.isSelected() != true) {
            currCoffee.removeAddIn(milkCheckboxOption.getText());
        } else if (syrupCheckboxOption.isSelected() != true) {
            currCoffee.removeAddIn(syrupCheckboxOption.getText());
        } else if (whippedCreamCheckboxOption.isSelected() != true) {
            currCoffee.removeAddIn(whippedCreamCheckboxOption.getText());
        }
    }

    /**
     * Method to calculate subtotal of coffee
     */
    @FXML
    public void calculateTotal(){

        if(sizeCombobox.getValue() != null && quantityCombobox.getValue() != null) {
            currCoffee.setSize(sizeCombobox.getValue());
            currCoffee.setQuantity(Integer.parseInt(quantityCombobox.getValue()));

            checkboxListeners();

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
