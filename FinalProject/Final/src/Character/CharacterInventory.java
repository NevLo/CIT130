package Character;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;
import Utils.Sort;

public class CharacterInventory extends Inventory {

    private final int DEFAULT_WIDTH = 10;
    private final int DEFAULT_HEIGHT = 10;
    private final Item[] DEFAULT_INVENTORY = new Item[]{
        new Item(ROPE, FIFTY),
        new Item(TORCH),
        new Item(KNIFE),
        new Item(RATIONS, THREE),
        new Item(MATCHES, FIFTY),
        new Item(GOLD, THREE)
    };

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

}
