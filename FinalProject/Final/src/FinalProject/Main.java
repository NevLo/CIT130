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
 * 11/9 Added some convenience methods to inventory class.
 * 11/19 HOLY SHIT WHAT A REWRITE. i rewrote the inventory class to break down into a character inventory and a chest inventory.
 * 		got rid of the ArrayList<ArrayList<Item>> that was my way of storing the items, and replaced with Item[][].
 * 
 */
package FinalProject;

import Character.*;
import Character.Character;
import Exceptions.*;
import Items.*;
import Utils.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character mainChar = new Character();
        Character sideChar = new Character();
        System.out.println("Space 1");
        mainChar.getInventory().displayInventory();
        sideChar.getInventory().displayInventory();
        System.out.println("Space 2");
        sideChar.setNPC(true);
        System.out.println("Space 3");
        sideChar.takeDamage(20, mainChar);
        System.out.println("Space 4");

        System.out.println("Main Character killed Side Character");
        mainChar.getInventory().displayInventory();
        
        /*
		 * Inventory inv = new Inventory(); inv.setDefaultInventory();
		 * inv.displayInventory(); Item matches = new Item("Matches", 15);
		 * inv.addToInventory(matches); inv.displayInventory(); inv.clearInventory();
		 * inv.displayInventory();
         */
    }
}
