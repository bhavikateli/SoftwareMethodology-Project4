package Project4;
import java.util.ArrayList;


/**
 * Class that holds information about a customers current order
 *
 * @author Bhavika Teli and Eduardo Alba
 */

public class Order implements Customizable{

    double subTotal = 0;
    double salesTax = 0;
    double total = 0;

    public ArrayList<MenuItem> orderList = new ArrayList<>();

    /**
     * Method to add item
     * @param obj to add
     * @return true if added, false otherwise
     */
    public boolean add(Object obj){
        if (obj instanceof Donut) {
            Donut donutCoffee = (Donut) obj;
            orderList.add(donutCoffee);
            return true;
        }else if(obj instanceof Coffee){
            Coffee coffee = (Coffee) obj;
            orderList.add(coffee);
            return true;
        }
        return false;
    }

    /**
     * Helper method to clear order list
     */
    public void clear(){
        orderList.clear();
        subTotal = 0;
        salesTax = 0;
        total = 0;
    }


    /**
     * Helper method to populate order view list
     * @return string version of orderList
     */
    public ArrayList<String> getStringArray(){

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++){
            result.add(orderList.get(i).toString());
        }

        return result;
    }

    /**
     * Helper method to return orderList
     * @return orderList Array
     */
    public ArrayList getOrderList(){
        return orderList;
    }

    /**
     * Method to remove item
     * @param obj to remove
     * @return true if removed, false otherwise
     */
    public boolean remove(Object obj){
        if(orderList.size() <= 0) {
            return false;
        }
        if (obj instanceof Donut) {
            Donut donutCoffee = (Donut) obj;
            orderList.remove(donutCoffee);
            return true;
        }else if(obj instanceof Coffee){
            Coffee coffee = (Coffee) obj;
            orderList.remove(coffee);
            return true;
        }
        return false;
    }

    /**
     * Helper method to set subtotal
     * @param subtotal to set variable to
     */
    public void setSubTotal(double subtotal){
        this.subTotal = this.subTotal + subtotal;
    }

    /**
     * Helper method to set subtotal
     */
    public void setSalesTax() {
        this.salesTax = subTotal * 0.0625;
    }

    /**
     * Helper method to set total
     */
    public void setTotal(){
        this.total = subTotal + salesTax;
    }

    /**
     * Helper method to get subtotal
     * @return subtotal variable
     */
    public double getSubTotal(){
        return subTotal;
    }

    /**
     * Helper method to get salesTax
     * @return salesTax variable
     */
    public double getSalesTax(){
        return salesTax;
    }

    /**
     * Helper method to get total
     * @return total variable
     */
    public double getTotal(){
        return total;
    }



}
