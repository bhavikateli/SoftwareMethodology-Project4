package Project4;

import java.util.ArrayList;

/**
 * Class that stores information about all orders placed in RUCafe
 *
 * @author Bhavika Teli and Eduardo Alba
 */
public class StoreOrder implements Customizable {

    ArrayList<String> orders = new ArrayList<>();
    ArrayList<Double> orderPrices = new ArrayList<>();


    /**
     * Method to add item
     *
     * @param obj to add
     * @return true if added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof String) {
            String order = (String) obj;
            orders.add(order);
            return true;
        }
        return false;
    }

    /**
     * Helper method to get orders
     *
     * @return Orders Array List
     */
    public ArrayList<String> getOrderList() {
        return orders;
    }

    /**
     * Helper method to get order prices
     *
     * @return OrderPrices Array list
     */
    public ArrayList getOrderPriceList() {
        return orderPrices;
    }

    /**
     * Helper method ot fill in total price
     *
     * @param orderPrice of order
     */
    public void addPrice(double orderPrice) {
        orderPrices.add(orderPrice);
    }

    public void removePrice(double orderPrice) {
        orderPrices.remove(orderPrice);
    }

    /**
     * Method to remove item
     *
     * @param obj to remove
     * @return true if removed, false otherwise
     */
    public boolean remove(Object obj) {

        if (obj instanceof String) {
            String order = (String) obj;
            orders.remove(order);
            return true;
        }
        return false;
    }


}
