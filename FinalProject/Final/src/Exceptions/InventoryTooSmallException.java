package Exceptions;

public class InventoryTooSmallException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void printStackTrace() {
        System.out.println("Inventory too small for operation.");
        System.out.println(this.getMessage());
    }
}
