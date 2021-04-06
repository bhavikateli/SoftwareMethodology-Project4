package Project4;

import java.util.ArrayList;

/**
 * An instance of menuItem created to store data about coffees
 *
 * @author Bhavika Teli and Eduardo Alb
 */

public class Coffee extends MenuItem implements Customizable {

    private static final double SHORT_PRICE = 1.99;
    private static final double TALL_PRICE = 2.49;
    private static final double GRANDE_PRICE = 2.99;
    private static final double VENTI_PRICE = 3.49;
    private static final double ADDIN_PRICE = 0.2;

    private String size;
    private int quantity;
    private int addIns;
    private ArrayList<String> addInList = new ArrayList<>();
    private final ArrayList<Coffee> coffeeList = new ArrayList<>();


    /**
     * Initial empty constructor
     */
    public Coffee() {
    }

    /**
     * Constructor with all of Coffee attributes
     *
     * @param size     of coffee
     * @param quantity amount to order
     * @param addIns   amount of addIns
     */
    public Coffee(String size, int quantity, int addIns) {
        this.size = size;
        this.quantity = quantity;
        this.addIns = addIns;
    }

    /**
     * Method to calculate price of each coffee
     *
     * @return price of coffee
     */
    public double itemPrice() {
        double price = 0;

        if (this.size == "Short") {
            price = SHORT_PRICE;
        } else if (this.size == "Tall") {
            price = TALL_PRICE;
        } else if (this.size == "Grande") {
            price = GRANDE_PRICE;
        } else if (this.size == "Venti") {
            price = VENTI_PRICE;
        }
        price = price + (ADDIN_PRICE * addIns);
        price = price * quantity;

        super.setPrice(price);
        return price;
    }

    /**
     * Helper method to get a string version of Coffee
     *
     * @return String with coffee information
     */
    public String toString() {

        String addins = "";

        for (int i = 0; i <= addInList.size(); i++) {

            if (addInList.size() == 0) {
                addins = "No addins";
                break;
            }

            if (addInList.size() == 1 || i == addInList.size() - 1) {
                addins = addins + addInList.get(i);
                break;
            }
            addins = addins + addInList.get(i) + ", ";
        }

        return this.size + " Coffee (" + this.quantity + ") [" + addins + "]";

    }

    /**
     * Method to update addIn variable and list
     *
     * @param addIn name
     */
    public void newAddIn(String addIn) {
        addInList.add(addIn);
        addIns++;
    }

    /**
     * Method to remove addIn variable and list
     *
     * @param addIn name
     */
    public void removeAddIn(String addIn) {
        addInList.remove(addIn);
        addIns--;
    }

    /**
     * Method to return quantity variable
     *
     * @return quantity variable
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method to set int to quantity
     *
     * @param quantity to set variable to
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method to return size variable
     *
     * @return String size
     */
    public String getSize() {
        return size;
    }

    /**
     * Method to set coffee size
     *
     * @param size to set variable to
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Method to add item
     *
     * @param obj to add
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {

        if (obj instanceof Coffee) {
            Coffee coffee = (Coffee) obj;
            coffeeList.add(coffee);
            return true;
        }
        return false;
    }

    /**
     * Method to remove item
     *
     * @param obj to remove
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {

        if (obj instanceof Coffee) {
            Coffee coffee = (Coffee) obj;
            coffeeList.remove(coffee);
            return true;
        }
        return false;
    }
}
