package Project4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Project4.Main.currOrder;
import static Project4.Main.storeOrder;


/**
 * Controller class to give functionality to Order.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class OrderController {

    @FXML
    private Text yourOrderText, subtotalText, salesTaxText;

    @FXML
    private Text totalText;

    @FXML
    private TextField subtotalTextArea, salesTaxTextArea, totalTextArea;

    @FXML
    private ListView<?> orderListView;

    @FXML
    private Button placeOrderButton, removeSelectedItemButton;

    final static private double ROUNDER = 100.0;


    /**
     * Method to intialize items in GUI
     */
    public void initialize() {

        ArrayList orderStrings = currOrder.getStringArray();
        orderListView.setItems(FXCollections.observableArrayList(orderStrings));

        salesTaxTextArea.setEditable(false);
        salesTaxTextArea.setText("$" + (Math.round(currOrder.getSalesTax() * ROUNDER) / ROUNDER));

        subtotalTextArea.setEditable(false);
        subtotalTextArea.setText("$" + (Math.round(currOrder.getSubTotal() * ROUNDER) / ROUNDER));

        totalTextArea.setEditable(false);
        totalTextArea.setText("$" + (Math.round(currOrder.getTotal() * ROUNDER) / ROUNDER));
    }

    /**
     * Method to place order into store
     */
    @FXML
    public void placeOrder() {

        if (currOrder.getTotal() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Input a a valid item! ");
            alert.showAndWait();
            return;
        }

        ArrayList<String> order = currOrder.getStringArray();
        String orderString = "";
        for (int i = 0; i < order.size(); i++) {
            orderString = orderString + order.get(i) + "\n";
        }

        storeOrder.add(orderString);
        storeOrder.addPrice(currOrder.getTotal());

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Order successfully placed! ");
        alert.showAndWait();

        currOrder.clear();

        Stage stage = (Stage) placeOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Method to remove order when button clicked
     */
    @FXML
    public void removeItem() {
        if (orderListView.getSelectionModel().getSelectedItem() != null) {
            int index = orderListView.getSelectionModel().getSelectedIndex();

            ArrayList<MenuItem> orderList = currOrder.getOrderList();
            MenuItem item = orderList.get(index);
            double price = item.getPrice();
            currOrder.setSubTotal(-price);
            subtotalTextArea.setText("$" + (Math.round(currOrder.getSubTotal() * ROUNDER) / ROUNDER));
            currOrder.setSalesTax();
            salesTaxTextArea.setText("$" + (Math.round(currOrder.getSalesTax() * ROUNDER) / ROUNDER));
            currOrder.setTotal();
            totalTextArea.setText("$" + (Math.round(currOrder.getTotal() * ROUNDER) / ROUNDER));

            currOrder.remove(item);
            ArrayList orderStrings = currOrder.getStringArray();
            orderListView.setItems(FXCollections.observableArrayList(orderStrings));
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Select an item to remove!");
            alert.showAndWait();
        }

    }

}

