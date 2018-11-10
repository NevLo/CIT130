/*
 *Modifications: 
 * 11/5 Added inventory, character, and item classes.
 *      inventory has basic functionality to hold items, and to display itself, and has a default inventory.
 *      item has 4 values, name, rarity, count, and value, i might split this up into the future to be an itemstack class
 *      character has nothing but a constructor right now.
 * 
 * 11/6 Added a method to add items to the inventory. added location and a utils folder for ease later.
 *      Added equals testing for items.    
 * 
 * 11/7 Added a method to add an inventory to another inventory and to clear an Inventory
 *      added some more instance variables to Character
 *      at this point, main is just being used to test my new additions to the base classes.
 *      added a way for a character to take damage, and if the character dies, the inventory is given to the attacker
 *      added a way to set an item to null, will make a nullItem class later.
 */
package FinalProject;


import Character.Inventory;
import Character.Item;
import Character.Character;
@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
                Character mainChar = new Character();
                Character sideChar = new Character();
                mainChar.getInventory().displayInventory();
                sideChar.getInventory().displayInventory();
                sideChar.setNPC(true);
                sideChar.takeDamage(20, mainChar);
                System.out.println("Main Character killed Side Character");
                mainChar.getInventory().displayInventory();
                /*
		Inventory inv = new Inventory();
		inv.setDefaultInventory();
		inv.displayInventory();
                Item matches = new Item("Matches", 15);
                inv.addToInventory(matches);
                inv.displayInventory();
                inv.clearInventory();
                inv.displayInventory();
                */
	}
}
