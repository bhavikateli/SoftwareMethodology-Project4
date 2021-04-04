package Project4;

public interface Customizable {

    /**
     * Method to add item
     * @param obj to add
     * @return true if added, false otherwise
     */
    boolean add(Object obj);

    /**
     * Method to remove item
     * @param obj to remove
     * @return true if removed, false otherwise
     */
    boolean remove(Object obj);
}
