package Character;

import Exceptions.InventoryTooSmallException;
import GameManager.GameManager;
import Items.Weapon;

/**
 * Character class allows the storage of data specific to the users's player and
 * NPC's/Enemies the user faces.
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
//REQ 5 PART 1
public class Character {

    private CharacterInventory inventory;
    private int health;
    private String name;
    private Location loc;
    private boolean npc;
    private int speed;

    /**
     * Gets the characterInventory
     *
     * @return
     */
    public CharacterInventory getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory
     *
     * @param inventory
     */
    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * lowers the characters health, and detects whether they are dead or not.
     *
     * @param damage
     * @param attacker
     */
    public void takeDamage(int damage, Character attacker) {
        health -= damage;
        //If health falls below zero
        if (health <= 0) {
            //if the character is the player
            if (!npc) {
                GameManager.end();
                //the character is an NPC.
            } else {
                //YO HOOOOOO. THIS IS ONE OF THE THINGS FOR NUMBER 2!!!!!! CAN YOU FIND ME?
                for (int i = 0; i < inventory.height; i++) {
                    for (int j = 0; j < inventory.width; j++) {
                        attacker.inventory.addToInventory(this.inventory.getItemAt(i, j));
                    }
                }

            }
        }
    }

    /**
     * sets whether they are an NPC or not.
     *
     * @param npc
     */
    public void setNPC(boolean npc) {
        this.npc = npc;
    }

    /**
     * Retrieves the NPC field.
     *
     * @return
     */
    public boolean isNPC() {
        return npc;
    }

    /**
     * Default Constructor
     */
    public Character() {
        health = 10;
        inventory = new CharacterInventory();
        try {
            inventory.setDefaultInventory();
        } catch (InventoryTooSmallException e) {
            e.printStackTrace();
        }
    }

    /**
     * Overloaded constructor for setting a character inventory.
     *
     * @param inventory
     */
    public Character(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Overloaded constructor for setting EVERYTHING!!!!
     *
     * @param inventory
     * @param health
     * @param name
     * @param loc
     * @param npc
     */
    public Character(CharacterInventory inventory, int health, String name, Location loc, boolean npc) {
        this.inventory = inventory;
        this.health = health;
        this.name = name;
        this.loc = loc;
        this.npc = npc;
        this.speed = 10;
    }

    /**
     * Returns the best weapon ( based on damage ) that the user has.
     *
     * @return
     */
    public Weapon getBestWeapon() {

        Weapon[] weapons = inventory.getWeaponArray();
        Weapon temp = weapons[0];
        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] != null) {
                //System.out.println(temp.toString() + "|||| " + weapons[i].toString());
                //System.out.println(temp.getDamage() + "|||| " + weapons[i].getDamage());
                temp = temp.getDamage() >= weapons[i].getDamage() ? temp : weapons[i];
            }
        }
        return temp;
    }

    /**
     * Gets the name of the user.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the location of the user.
     *
     * @return
     */
    public Location getLoc() {
        return loc;
    }

    /**
     * Sets the location of the user.
     *
     * @param loc
     */
    public void setLoc(Location loc) {
        this.loc = loc;
    }

    /**
     * Gets the speed of the user.
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the user.
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets the current health of the character.
     *
     * @return
     */
    public int getHealth() {

        return health;
    }

}
