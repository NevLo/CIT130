package Exceptions;

/**
 * @author Christian Pilley, Kallie Mendoza
 *
 *
 */
public class InventoryTooSmallException extends Exception {

    /**
     * IDK what this means, but it was barking at me if i didnt have it
     * soooooooooo.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Prints a new stack trace
     */
    @Override
    public void printStackTrace() {
        System.out.println("Inventory too small for operation.");
        System.out.println(this.getMessage());
    }
}
