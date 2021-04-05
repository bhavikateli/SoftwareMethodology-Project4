package Project4;

import java.io.DataInput;
import java.util.ArrayList;

public class Order implements Customizable{

    private static final String NOT_FOUND = "-1";
    double subTotal = 0;
    double salesTax = (subTotal * 0.0625);
    double total = subTotal + salesTax;

    ArrayList<MenuItem> orderList = new ArrayList<>();

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

    public ArrayList<String> getStringArray(){

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++){
            result.add(orderList.get(i).toString());
        }
        return new ArrayList<>();
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
        if (obj instanceof Donut || obj instanceof Coffee) {
            orderList.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Method to convert order items into strings
     * @param obj to convert
     * @return string with item information
     */
    public String toString(Object obj){
        if(obj instanceof Donut || obj instanceof Coffee){
            MenuItem donutCoffee = (MenuItem) obj;
            return donutCoffee.toString();
        }
        return NOT_FOUND;
    }

    /**
     * Helper method to set subtotal
     * @param subtotal to set variable to
     */
    public void setSubTotal(double subtotal){
        this.subTotal = this.subTotal + subtotal;
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
