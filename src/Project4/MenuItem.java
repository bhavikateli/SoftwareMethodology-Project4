package Project4;

/**
 * Superclass of all menu items
 * @author Bhavika Teli and Eduardo Alba
 */
public class MenuItem {

    private double price;

    /**
     * Initial empty constructor
     */
    public MenuItem(){}

    /**
     * Constructor with price
     * @param price for menu-item
     */
    public MenuItem(double price){
        this.price = price;
    }

    /**
     * Method to return price variable
     * @return price variable
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method to set double to price
     * @param price to set variable to
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
