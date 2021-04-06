package Project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static Project4.Main.storeOrder;


/**
 * Controller class to give functionality to StoreOrder.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class StoreOrderController {

    @FXML
    private Text storeText;

    @FXML
    private ComboBox<String> orderNumberCombobox;

    @FXML
    private Text totalText;

    @FXML
    private TextField totalTextArea;

    @FXML
    private ListView<String> ordersListView;

    @FXML
    private Button exportOrderButton;

    @FXML
    private Button cancelOrderButton;

    private ObservableList<String> orderNumber = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    final static private double ROUNDER = 100.0;


    /**
     * Method to intialize items in GUI
     */
    public void initialize() {
        orderNumberCombobox.setItems(orderNumber);
        totalTextArea.setEditable(false);
    }

    /**
     * Helper method to show orders according to
     */
    @FXML
    public void showOrder() {

        int index = orderNumberCombobox.getSelectionModel().getSelectedIndex();
        ArrayList order = storeOrder.getOrderList();
        ArrayList orderPrices = storeOrder.getOrderPriceList();

        if (order.size() == 0 || index >= order.size()) {
            String orderString = "No known order";
            ordersListView.setItems(FXCollections.observableArrayList(orderString));
            return;
        }

        String orderString = (String) order.get(index);
        ordersListView.setItems(FXCollections.observableArrayList(orderString));
        double total = (double) orderPrices.get(index);
        double totatInt = Math.round(total * ROUNDER) / ROUNDER;
        totalTextArea.setText("$" + totatInt);
    }

    /**
     * Method to give functionality to removing an order
     */
    @FXML
    public void removeOrder() {

        int index = orderNumberCombobox.getSelectionModel().getSelectedIndex();
        ArrayList order = storeOrder.getOrderList();

        if (index < 0 || index >= order.size()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Select a valid order from combobox to remove!");
            alert.showAndWait();
            return;
        }

        String orderString = (String) order.get(index);
        ArrayList orderPrices = storeOrder.getOrderPriceList();

        double total = (double) orderPrices.get(index);
        storeOrder.remove(orderString);
        storeOrder.removePrice(total);

        showOrder();

    }

    /**
     * Method to export all orders into a file
     */
    @FXML
    public void fileExport() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save the File");
        File file = chooser.showSaveDialog(new Stage());
        String path = file.getAbsolutePath();

        if (file == null || path == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Invalid file/path");
            alert.showAndWait();
            return;
        }

        ArrayList<String> orderList = storeOrder.getOrderList();
        ArrayList<Double> orderPriceList = storeOrder.getOrderPriceList();
        try {
            FileWriter myWriter = new FileWriter(path);

            if (orderList.size() == 0) {
                myWriter.write("No orders in database");
                myWriter.close();
                return;
            }
            for (int i = 0; i < orderList.size(); i++) {
                myWriter.write("---------------Order" + (i + 1) + "---------------");
                myWriter.write('\n');
                myWriter.write(orderList.get(i));
                myWriter.write('\n');
                myWriter.write("Total:" + (Math.round((orderPriceList.get(i)) * ROUNDER) / ROUNDER));
                myWriter.write('\n');


            }
            myWriter.close();
        } catch (IOException e) {
        }


    }

}
