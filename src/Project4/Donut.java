package Project4;

import java.util.ArrayList;

/**
 * An instance of menuItem created to store data about donuts
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class Donut extends MenuItem implements Customizable {

    final static private double YEAST_PRICE = 1.39;
    final static private double CAKE_PRICE = 1.59;
    final static private double HOLE_PRICE = 0.33;


    private int quantity;
    private String type;
    private String flavor;

    private final ArrayList<Donut> donutList = new ArrayList<>();

    /**
     * Initial Constructor
     */
    public Donut() {
    }

    /**
     * Constructor with all of Donut's info
     *
     * @param price    of donut
     * @param quantity number of each donuts
     * @param type     of donut
     * @param flavor   of donut
     */
    public Donut(double price, int quantity, String type, String flavor) {
        super(price);
        this.quantity = quantity;
        this.type = type;
        this.flavor = flavor;
    }

    /**
     * Method to calculate price of each donut
     *
     * @return price of item
     */
    public double itemPrice() {
        double price = 0;

        if (this.type == "Yeast Donut") {
            price = YEAST_PRICE;
        } else if (this.type == "Donut Hole") {
            price = HOLE_PRICE;
        } else if (this.type == "Cake Donut") {
            price = CAKE_PRICE;
        }
        price = price * quantity;

        super.setPrice(price);
        return price;
    }

    /**
     * Method that converts donut information into a string
     *
     * @return string
     */
    public String toString() {
        return type + "," + flavor + "," + quantity;
    }

    /**
     * Method to add item
     *
     * @param obj to add
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            Donut donut = (Donut) obj;
            donutList.add(donut);
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
        if (obj instanceof Donut) {
            Donut donut = (Donut) obj;
            donutList.remove(donut);
            return true;
        }
        return false;
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
     * Method to return type variable
     *
     * @return String type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set donut type
     *
     * @param type to set variable to
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to return flavor variable
     *
     * @return String flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Method to set flavor of donut
     *
     * @param flavor to set variable to
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

}
