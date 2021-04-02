package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller class to give functionality to OrderDonut.fxml
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class OrderDonutController {

    @FXML
    private Text donutText;

    @FXML
    private ComboBox<?> donutSelectionComboBox;

    @FXML
    private ListView<?> flavorSelectionListView;

    @FXML
    private ListView<?> finalDonutsListView;

    @FXML
    private ComboBox<?> donutAmountComboBox;

    @FXML
    private Button addDonutButton;

    @FXML
    private Button removeDonutButton;

    @FXML
    private Text subtotalText;

    @FXML
    private TextField subtotalTextArea;

    @FXML
    private Button addToOrderButton;

    @FXML
    void addDonut() {

    }

    @FXML
    void addToOrder() {

    }

    @FXML
    void removeDonut() {

    }

}

