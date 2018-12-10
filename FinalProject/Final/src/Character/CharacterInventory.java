package Character;

import java.util.Arrays;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;
import Items.Weapon;
import Utils.Sort;

public class CharacterInventory extends Inventory {
	
    private final int DEFAULT_WIDTH = 10;
    private final int DEFAULT_HEIGHT = 10;
    private final Item[] DEFAULT_INVENTORY = new Item[]{
       
        
        new Weapon(KNIFE, THREE),
        new Item(RATIONS, THREE),
        new Item(MATCHES, FIFTY),
        new Item(GOLD, THREE)
    };
    private Weapon[] weapons = new Weapon[DEFAULT_HEIGHT * DEFAULT_WIDTH];
    public CharacterInventory() {
        inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        for(int i = 0; i < height; i++) {
        	for(int j = 0; j < height; j++) {
            	inv[i][j] = new NullItem();
            }
        }
        numItemStacks = 0;
    }
    public CharacterInventory(Item...items) {
    	inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        for(Item i : items) {
        	addToInventory(i);
        }
    }
    @Override
    public void setDefaultInventory() throws InventoryTooSmallException {
        clearInventory();
        if ((width == DEFAULT_WIDTH && height == DEFAULT_HEIGHT) || width >= 5) {
            int count = 0;
            for (Item i : DEFAULT_INVENTORY) {
                inv[0][count] = i;
                count++;
            }
        } else {
            if (width * height < 5) {
                throw new InventoryTooSmallException();
            } else {
                int count = 0;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (!(count > 5)) {
                            inv[i][j] = DEFAULT_INVENTORY[count];
                        } else {
                            inv[i][j] = new NullItem();
                        }
                    }
                }
            }
        }
        numItemStacks = 5;
    }


    public void sortInventory(Sort sort) {
        switch (sort) {
            case Name:
            case Value:
            case Rarity:
            case StackSize:
        }
    }

    public Item getItemAt(int i, int j) {
        return inv[i][j];
    }
    public Weapon[] getWeaponArray() {
    	fillWeaponArray();
		return weapons;
    	
    }
	private void fillWeaponArray() {
		Arrays.fill(weapons, null);
		int counter = 0;
		for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(inv[i][j] instanceof Weapon) {
                	weapons[counter] = (Weapon) inv[i][j];
                	counter++;
                }
            }
        }
	}

}
