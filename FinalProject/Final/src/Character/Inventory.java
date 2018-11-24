package Character;


import java.util.Arrays;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;
import Utils.intDuo;

public abstract class Inventory {
    protected Item[][] inv;


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
    protected int numItemStacks = 0;

    public abstract void setDefaultInventory() throws InventoryTooSmallException;

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
						}
						//if the items are equal
						if (inv[i][j].equals(item)) {
							inv[i][j].setCount(inv[i][j].getCount() + item.getCount());
							return;
						}
					}
				}
				//if it gets to here, it is a non-matching item and will be added to the first available slot.
				//numstacks will be incremented
				for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (inv[i][j] instanceof NullItem) {
                            inv[i][j] = item;
                            numItemStacks++;
                            return;
                            
                        }
                    }
                }
			}
			//else inventory is empty
            else{
              inv[0][0] = item;  
            }
        }
    }

    public void clearInventory() {
    	
        for (int i = 0; i < height; i++) {
            Arrays.fill(inv[i], new NullItem());
        }
        numItemStacks = 0;
    }

    public intDuo searchForItem(Item item) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j].equals(item)) {
                    return new intDuo(i, j);
                }
            }
        }
        return new intDuo(-1, -1);
    }

    public boolean HasItem(Item item) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j].equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayInventory() {
        if (numItemStacks == 0) {
            System.out.println(EMPTY_INVENTORY);
            return;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
            	if (inv[i][j] instanceof NullItem) {
                    continue;
                }
                
            	Item temp = inv[i][j];
                System.out.print(temp.getItemName() + " x" + temp.getCount() + "\t");
            }
            System.out.println();
        }
    }

    public void addToInventory(Inventory invent){
        //this is for the case that the inventories are the same, but will also occasionally grab some when not the same
        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                if(invent.inv[i][j] == inv[i][j]){
                    inv[i][j].setCount(inv[i][j].getCount() + invent.inv[i][j].getCount());
                    invent.numItemStacks--;
                    invent.inv[i][j] = new NullItem();
                }
            }
        }
        //This will add each item to the target inventory
        if(invent.numItemStacks != 0){
            for(int i = 0; i < invent.height; i++){
                for(int j = 0; j < invent.width; j++) {
                	addToInventory(invent.inv[i][j]);
                }                    
            }
        }
    }

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
   

}
