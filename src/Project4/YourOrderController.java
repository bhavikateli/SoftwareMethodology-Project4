package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller class to give functionality to YourOrder.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class YourOrderController {

    @FXML
    private Text yourOrderText;

    @FXML
    private Text subtotalText;

    @FXML
    private Text salesTaxText;

    @FXML
    private Text totalText;

    @FXML
    private TextField subtotalTextArea;

    @FXML
    private TextField salesTaxTextArea;

    @FXML
    private TextField totalTextArea;

    @FXML
    private ListView<?> orderListView;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button removeSelectedItemButton;

    @FXML
    void placeOrder() {

    }

    @FXML
    void removeItem() {

    }

}

