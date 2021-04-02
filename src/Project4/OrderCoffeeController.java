package Project4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    private CheckBox creamCheckboxOption;

    @FXML
    private CheckBox milkCheckboxOption;

    @FXML
    private CheckBox whippedCreamCheckboxOption;

    @FXML
    private CheckBox syrupCheckboxOption;

    @FXML
    private CheckBox caramelCheckboxOption;

    @FXML
    private ComboBox<?> sizeCombobox;

    @FXML
    private ComboBox<?> quantityCombobox;

    @FXML
    private TextField totalTextArea;

    @FXML
    private Button addToOrderButton;

    @FXML
    void addToOrder() {

    }

}
