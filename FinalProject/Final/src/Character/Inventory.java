package Character;

import java.util.Arrays;

import Exceptions.InventoryTooSmallException;

import Items.Item;
import Items.NullItem;
import Items.Potion;
import Items.Weapon;
import Utils.intDuo;

/**
 * Base class for the inventory. houses some methods that will be in both child
 * classes.
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
public abstract class Inventory {

    protected Item[][] inv; //Multi dimensional array! REQ 6 part 2!

    protected final String ROPE = "Rope";
    protected final String TORCH = "Torch";
    protected final String KNIFE = "Knife";
    protected final String RATIONS = "Rations";
    protected final String MATCHES = "Matches";
    protected final String GOLD = "Gold";
    protected final String EMPTY_INVENTORY = "Empty Inventory";
    protected final int FIFTY = 50;
    protected final int THREE = 3;

    protected int width;
    protected int height;
    public int numItemStacks = 0;

    /**
     * sets the default inventory.
     *
     * @throws InventoryTooSmallException
     */
    public abstract void setDefaultInventory() throws InventoryTooSmallException;

    /**
     * Adds an item to the inventory.
     *
     * @param item
     */
    public void addToInventory(Item item) {
        //If the inventory isnt full
        if (numItemStacks != width * height) {
            //if there are items in the inventory
            if (numItemStacks != 0) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        //if the inventory space is a null item
                        if (inv[i][j] instanceof NullItem || inv[i][j] == null) {
                            continue;
                        } // END if
                        //if the items are equal
                        if (inv[i][j].equals(item)) {
                            inv[i][j].setCount(inv[i][j].getCount() + item.getCount());
                            return;
                        } //END if
                    }// END for
                } // END for
                //if it gets to here, it is a non-matching item and will be added to the first available slot.
                //numstacks will be incremented
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (inv[i][j] instanceof NullItem) {
                            inv[i][j] = item;
                            numItemStacks++;
                            return;

                        } // END if
                    }// END for
                }// END for
            }// END if
            //else inventory is empty
            else {
                inv[0][0] = item;
            }// END else
        }// END if
    }// END method

    /**
     * Empties the Inventory.
     */
    public void clearInventory() {

        for (int i = 0; i < height; i++) {
            Arrays.fill(inv[i], new NullItem());
        } // END for
        numItemStacks = 0;
    } // END method

    /**
     * Returns the row and column as an intDuo of the specified item if the item
     * is not there, it will return -1, -1
     *
     * @param item
     * @return intDuo
     */
    public intDuo searchForItem(Item item) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j] != null) {
                    if (inv[i][j].equals(item)) {
                        return new intDuo(i, j);
                    } // END if
                }
            } // END for 
        } // END for 
        return new intDuo(-1, -1);
    }

    public intDuo searchForItem(Weapon wep) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j] != null) {
                    if (inv[i][j].equals(wep)) {
                        return new intDuo(i, j);
                    } // END if
                }
            } // END for 
        } // END for 
        return new intDuo(-1, -1);
    }

    /**
     * Returns whether or not the inventory has a specific item.
     *
     * @param item
     * @return boolean
     */
    public boolean HasItem(Item item) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j].equals(item)) {
                    return true;
                }// END if
            }// END for
        }// END for
        return false;
    }

    public boolean HasAWeapon() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j] instanceof Weapon) {
                    return true;
                }// END if
            }// END for
        }// END for
        return false;
    }

    /**
     * Displays the Inventory to the console window.
     */
    public void displayInventory() {
        //if the inventory is empty, display empty inventory.
        if (numItemStacks == 0) {
            System.out.println(EMPTY_INVENTORY);
            return;
        } // END if
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //if it is a nullitem, continue.
                if (inv[i][j] instanceof NullItem || inv[i][j] == null) {
                    continue;
                } // END if
                if(inv[i][j] instanceof Weapon){
                    Weapon temp = (Weapon) inv[i][j];
                    System.out.print(temp.getItemName() + " x" + temp.getCount() + "\t");
                } else if(inv[i][j] instanceof Potion){    
                    Potion temp = (Potion) inv[i][j];
                    System.out.print(temp.getItemName() + " x" + temp.getCount() + "\t");
                } else {
                    Item temp = inv[i][j];
                    System.out.print(temp.getItemName() + " x" + temp.getCount() + "\t");
                }
            }// END for
            System.out.println();
        } // END for
    } // END method

    /**
     * Adds an inventory to an inventory.
     *
     * @param invent
     */
    public void addToInventory(Inventory invent) {
        //this is for the case that the inventories are the same, but will also occasionally grab some when not the same
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (invent.inv[i][j] == inv[i][j]) {
                    inv[i][j].setCount(inv[i][j].getCount() + invent.inv[i][j].getCount());
                    invent.numItemStacks--;
                    invent.inv[i][j] = new NullItem();
                }
            }
        }
        //This will add each item to the target inventory
        if (invent.numItemStacks != 0) {
            for (int i = 0; i < invent.height; i++) {
                for (int j = 0; j < invent.width; j++) {
                    addToInventory(invent.inv[i][j]);
                }
            }
        }
    }

    /**
     * Turns the 2D item array into a 1D item array, for use in the inventory
     * sorting.
     *
     * @return Item[]
     */
    public Item[] to1DArray() {

        Item[] temp = new Item[width * height];
        int i = 0;
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                temp[i] = inv[j][k];
                i++;
            }
        }
        return temp;
    }

    /**
     * itemAt will return the item that is at the specified index.
     *
     * @param s
     * @return
     */
    public Item itemAt(intDuo s) {
        if (s.x < 0 || s.y < 0) {
            return null;
        }
        return inv[s.x][s.y];
    }

}
