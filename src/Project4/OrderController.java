package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static Project4.Main.currOrder;

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
        subtotalTextArea.setEditable(false);
        subtotalTextArea.setText(String.valueOf(Math.round(currOrder.getSubTotal() * ROUNDER) / ROUNDER));
        totalTextArea.setEditable(false);

    }

    @FXML
    void placeOrder() {

    }

    @FXML
    void removeItem() {

    }

}

