package Character;

import java.util.Arrays;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;
import Items.Weapon;
import Utils.Sort;

/**
 * Character Inventory is the inventory of the character is extends the
 * Inventory class and is a sister class to the ChestInventory
 *
 * @author Christian Pilley & Kallie Mendoza
 */
public class CharacterInventory extends Inventory {

    private final int DEFAULT_WIDTH = 10;
    private final int DEFAULT_HEIGHT = 10;
    private final Item[] DEFAULT_INVENTORY = new Item[]{  //REQ 6 PART 1
        new Weapon(KNIFE, THREE),
        new Item(RATIONS, THREE),
        new Item(MATCHES, FIFTY),
        new Item(GOLD, THREE)
    };
    private Weapon[] weapons = new Weapon[DEFAULT_HEIGHT * DEFAULT_WIDTH]; //REQ 6 PART 3

    /**
     * Default constructor
     */
    public CharacterInventory() {
        inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                inv[i][j] = new NullItem();
            }
        }
        numItemStacks = 0;
    }

    /**
     * Overloaded constructor for adding an array of items to start with.
     *
     * @param items
     */
    public CharacterInventory(Item... items) {
        inv = new Item[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        for (Item i : items) {
            addToInventory(i);
        }
    }

    /**
     * Sets the default inventory to have some items.
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

    /**
     * method to sort the inventory by the selected sort. never implemented.
     *
     * @param sort
     */
    public void sortInventory(Sort sort) {
        switch (sort) {
            case Name:
            case Value:
            case Rarity:
            case StackSize:
        }
    }

    /**
     * Returns an item and the specified inventory address
     *
     * @param i - row
     * @param j - col
     * @return Item
     */
    public Item getItemAt(int i, int j) {
        return inv[i][j];
    }

    /**
     * Gets the array of weapons the character has, but fills it first so we
     * dont get a null statement.
     *
     * @return
     */
    public Weapon[] getWeaponArray() {
        fillWeaponArray();
        return weapons;

    }

    private void fillWeaponArray() {
        Arrays.fill(weapons, null);
        int counter = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (inv[i][j] instanceof Weapon) {
                    weapons[counter] = (Weapon) inv[i][j];
                    counter++;
                }
            }
        }
    }
}
