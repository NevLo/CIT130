package Character;

import Exceptions.InventoryTooSmallException;
import GameManager.GameManager;

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
    private int speed;
    

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public void takeDamage(int damage, Character attacker) {
        health -= damage;
       //If health falls below zero
        if (health <= 0) {
        	//if the character is the player
            if (!npc) {
                GameManager.end();
                //the character is an NPC.
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
    public boolean isNPC() {
    	return npc;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
