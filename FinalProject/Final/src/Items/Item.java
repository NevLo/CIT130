package Items;

import Utils.Rarity;

/**
 * Item class! allows items to be a thing. Has 4 fields: Name, Count, Rarity,
 * and Value.
 *
 * @author Christian Pilley & Kallie Mendoza
 *
 */
public class Item {

    protected String name;
    protected int count;
    protected Rarity rarity;
    protected float value;

    /**
     * default constructor
     */
    public Item() {

    }

    /**
     * Overloaded constructor that sets the name.
     *
     * @param name
     */
    public Item(String name) {
        this.name = name;
        this.count = 1;
        value = 0;

        rarity = Rarity.common;
    }

    /**
     * Overloaded constructor that sets the name and the count.
     *
     * @param name
     * @param count
     */
    public Item(String name, int count) {
        this.name = name;
        this.count = count;
        value = 0;
        rarity = Rarity.common;
    }

    /**
     * Getter for the name.
     *
     * @return
     */
    public String getItemName() {
        return name;
    }

    /**
     * getter for the count.
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * setter for the count.
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Overridden equals method.
     *
     * @param item
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            Item item = (Item) obj;
            return item.name.equals(this.name)
                    && item.rarity == this.rarity
                    && item.value == this.value;
        }
        return false;
    }

    /**
     * Overridden toString method.
     *
     * @return
     */
    @Override
    public String toString() {
        return rarity + ": " + name + " x" + count;
    }

}
