package Character;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;

public class CharacterInventory extends Inventory {

    private final int DEFAULT_WIDTH = 10;
    private final int DEFAULT_HEIGHT = 10;
    private final Item[] DEFAULT_INVENTORY = new Item[]{
        new Item(ROPE, FIFTY),
        new Item(TORCH),
        new Item(KNIFE),
        new Item(RATIONS, THREE),
        new Item(MATCHES, FIFTY)
    };

    public CharacterInventory() {
        inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
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

    @Override
    public void addToInventory(Item item) {
        if (numItemStacks != width * height) {
            boolean added = false;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(inv[i][j] instanceof NullItem){
                        continue;
                    }
                    if (inv[i][j].equals(item)) {
                        inv[i][j].setCount(inv[i][j].getCount() + item.getCount());
                        added = true;
                        break;
                    }
                }
                if (added) {
                        break;
                }
            }
            if (!added) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (inv[i][j] instanceof NullItem) {
                            inv[i][j] = item;
                            return;
                        }
                    }
                }
            }
            numItemStacks++;
        }
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
