package Project4;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static Project4.Main.currOrder;


/**
 * Controller class to give functionality to Donut.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class DonutController {

    @FXML
    private Text donutText;

    @FXML
    private ComboBox<String> donutSelectionComboBox, donutAmountComboBox;

    @FXML
    private ListView<String> flavorSelectionListView, finalDonutsListView;

    @FXML
    private Button addDonutButton, removeDonutButton, addToOrderButton;

    @FXML
    private Text subtotalText;

    @FXML
    private TextField subtotalTextArea;


    ArrayList<String> orders = new ArrayList<>();
    ArrayList<Double> orderPrices = new ArrayList<>();

    private ObservableList<String> donutType = FXCollections.observableArrayList("Yeast Donut", "Donut Hole", "Cake Donut");
    private ObservableList<String> yeastFlavors = FXCollections.observableArrayList("Confetti", "Glazed", "Strawberry");
    private ObservableList<String> holeFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Jelly");
    private ObservableList<String> cakeFlavors = FXCollections.observableArrayList("Blueberry", "Pumpkin", "Vanilla");
    private ObservableList<String> quantity = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    final static private int NOT_FOUND = -1;
    final static private double ROUNDER = 100.0;

    Donut currDonut = new Donut(0, 1, "Yeast Donut", "Confetti");

    /**
     * Method to intialize items in GUI
     */
    public void initialize() {
        donutSelectionComboBox.setItems(donutType);
        donutAmountComboBox.setItems(quantity);

        subtotalTextArea.setEditable(false);

    }

    /**
     * Method to help fill in flavors list as user selects type of donut
     */
    @FXML
    void flavorDropdown() {
        String type = donutSelectionComboBox.getValue();
        currDonut.setType(type);

        if (type.equals("Yeast Donut")) {
            flavorSelectionListView.setItems(yeastFlavors);
        } else if (type.equals("Donut Hole")) {
            flavorSelectionListView.setItems(holeFlavors);
        } else if (type.equals("Cake Donut")) {
            flavorSelectionListView.setItems(cakeFlavors);
        }
    }

    /**
     * Method to add donut when button clicked
     */
    @FXML
    void addDonut() {

        if (flavorSelectionListView.getSelectionModel().getSelectedItem() != null
                && donutAmountComboBox.getValue() != null
                && donutSelectionComboBox.getValue() != null) {
            //addToOrderButton.setDisable(false);
            currDonut.setFlavor(flavorSelectionListView.getSelectionModel().getSelectedItem());
            currDonut.setQuantity(Integer.parseInt(donutAmountComboBox.getValue()));
            orders.add(currDonut.toString());
            finalDonutsListView.setItems(FXCollections.observableArrayList(orders));
            orderPrices.add(currDonut.itemPrice());
            subtotalTextArea.setText("$" + calculateSubtotal());
        }
    }

    /**
     * Helper method to calculate subtotal
     *
     * @return total price of orders
     */
    @FXML
    public String calculateSubtotal() {

        double total = 0;

        for (int i = 0; i < orderPrices.size(); i++) {
            total = total + orderPrices.get(i);
        }

        double price = Math.round(total * ROUNDER) / ROUNDER;
        String result = String.valueOf(price);

        return result;
    }

    /**
     * Helper method for remove method when removing price from OrderPrices list
     *
     * @return index where item is located
     */
    public int getIndex(String orderToRemove) {

        for (int index = 0; index < orders.size(); index++) {
            if (orders.get(index).equals(orderToRemove)) {
                return index;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Method to add to order when button is clicked
     */
    @FXML
    void addToOrder() {

        if (Bindings.isEmpty(finalDonutsListView.getItems()).get() == false) {

            for (int i = 0; i < orders.size(); i++) {
                Donut donut = getDetails(orders.get(i), i);
                currOrder.add(donut);
            }
            double total = Double.parseDouble(calculateSubtotal());
            currOrder.setSubTotal(total);
            currOrder.setSalesTax();
            currOrder.setTotal();
            Stage stage = (Stage) addDonutButton.getScene().getWindow();
            stage.close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Order has been added!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Input a type, flavor and quantity!");
            alert.showAndWait();
        }

    }

    /**
     * Helper method to create a donut
     *
     * @param donutDetails information about donut
     * @param i            index of donut in orders
     * @return donut with information from string donutDetails
     */
    public Donut getDetails(String donutDetails, int i) {

        String type = "";
        String flavor = "";
        String quantity = "0";
        double price = orderPrices.get(i);

        StringTokenizer tokenizer = new StringTokenizer(donutDetails, ",");
        while (tokenizer.hasMoreTokens()) {
            type = tokenizer.nextToken();
            flavor = tokenizer.nextToken();
            quantity = tokenizer.nextToken();
        }

        Donut donut = new Donut(price, Integer.parseInt(quantity), type, flavor);
        return donut;
    }

    /**
     * Method to add donut when button clicked
     */
    @FXML
    void removeDonut() {

        if (finalDonutsListView.getSelectionModel().getSelectedItem() != null) {
            int index = getIndex(finalDonutsListView.getSelectionModel().getSelectedItem());
            if (index != NOT_FOUND) {
                orderPrices.remove(index);
                orders.remove(finalDonutsListView.getSelectionModel().getSelectedItem());
                finalDonutsListView.setItems(FXCollections.observableArrayList(orders));
                subtotalTextArea.setText("$" + calculateSubtotal());

            }
        }
    }

}

