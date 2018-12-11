package Character;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;

/**
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
public class ChestInventory extends Inventory {

    private final int DEFAULT_WIDTH = 8;
    private final int DEFAULT_HEIGHT = 5;

    private int randomGold() {
        return (int) (Math.random() * 100);
    }

    private final Item[] DEFAULT_INVENTORY = new Item[]{
        new Item(GOLD, randomGold())
    };
    public ChestInventory(Item... items) {
        inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        for (Item i : items) {
            addToInventory(i);
        }
        numItemStacks = items.length;
    }
    /**
     * Sets the default inventory for the chest.
     *
     * @throws InventoryTooSmallException
     */
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
            if (width * height > 5) {
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
                numItemStacks = 5;
                return;
            }
            throw new InventoryTooSmallException();
        }
    }
}
