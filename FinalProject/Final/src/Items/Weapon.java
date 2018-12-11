package Items;

import Utils.Rarity;

/**
 * A child class of the item class, allows the item to hold a damage value.
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
public class Weapon extends Item {

    public int damage;

    /**
     * Overloaded constructor for setting its name.
     *
     * @param string
     */
    public Weapon(String string) {
        name = string;
        value = 10;
        count = 1;
        rarity = Rarity.rare;
        damage = 10;
    }

    /**
     * Overloaded constructor for setting its name and damage.
     *
     * @param string
     * @param damage
     */
    public Weapon(String string, int damage) {
        name = string;
        value = 10;
        count = 1;
        rarity = Rarity.rare;
        this.damage = damage;
    }

    /**
     * overloaded constructor for setting its name, damage, and rarity.
     *
     * @param string
     * @param damage
     * @param rarity
     */
    public Weapon(String string, int damage, Rarity rarity) {
        name = string;
        value = 10;
        count = 1;
        this.rarity = rarity;
        this.damage = damage;
    }

    /**
     * Overloaded equals method.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Weapon) {
            Weapon temp = (Weapon) obj;
            return name.equals(temp.name)
                    && value == temp.value
                    && rarity == temp.rarity
                    && damage == temp.damage;
        }
        return false;

    }

    /**
     * Returns the damage that the weapon deals.
     *
     * @return
     */
    public int getDamage() {
        return damage;
    }

}
