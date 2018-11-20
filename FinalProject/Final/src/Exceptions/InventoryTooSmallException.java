package Exceptions;

public class InventoryTooSmallException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void printStackTrace() {
        System.out.println("I dont know how you fucking managed to be an idiot, you have a too small of inventory for this operation."
                + "\n like, how? are you intentionally fucking a player here? or are you being dumb and setting an npc's inventory size to be retarded?"
                + "\n anyhow, you fucked up. fix it dipshit.");
        System.out.println(this.getMessage());
    }
}
