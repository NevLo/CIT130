/**
 *Modifications: 
 * 11/5 Added inventory, character, and item classes.
 * inventory has basic functionality to hold items, and to display itself, and has a default inventory.
 * item has 4 values, name, rarity, count, and value, i might split this up into the future to be an itemstack class
 * character has nothing but a constructor right now.
 * 
 */
package FinalProject;

import Character.Inventory;

public class Main {
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.setDefaultInventory();
		inv.displayInventory();
	}
}
