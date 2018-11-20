package Character;

import Exceptions.InventoryTooSmallException;

/**
 *
 * @author NevLo
 *
 */
public class Character {

    private CharacterInventory inventory;
    private int health;
    private String name;
    private Location loc;
    private boolean npc;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public void takeDamage(int damage, Character attacker) {
        health -= damage;
        if (health <= 0) {
            if (!npc) {
                // Die
            } else {
                for (int i = 0; i < inventory.height; i++) {
                    for (int j = 0; j < inventory.width; j++) {
                        attacker.inventory.addToInventory(this.inventory.getItemAt(i, j));
                    }
                }

            }
        }
    }

    public void setNPC(boolean npc) {
        this.npc = npc;
    }

    public Character() {
        health = 10;
        inventory = new CharacterInventory();
        try {
            inventory.setDefaultInventory();
        } catch (InventoryTooSmallException e) {
            e.printStackTrace();
        }
    }

    public Character(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public Character(CharacterInventory inventory, int health, String name, Location loc, boolean npc) {
        this.inventory = inventory;
        this.health = health;
        this.name = name;
        this.loc = loc;
        this.npc = npc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

}
