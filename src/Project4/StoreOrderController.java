package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller class to give functionality to StoreOrder.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class StoreOrderController {

    @FXML
    private Text storeText;

    @FXML
    private ComboBox<?> orderNumberCombobox;

    @FXML
    private Text totalText;

    @FXML
    private TextField totalTextArea;

    @FXML
    private ListView<?> ordersListView;

    @FXML
    private Button exportOrderButton;

    @FXML
    private Button cancelOrderButton;

}
