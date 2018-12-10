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
 *      
 * 11/9 Added some convenience methods to inventory class.
 * 
 * 11/19 HOLY SHIT WHAT A REWRITE. i rewrote the inventory class to break down into a character inventory and a chest inventory.
 * 		got rid of the ArrayList<ArrayList<Item>> that was my way of storing the items, and replaced with Item[][].
 * 
 * 11/24 Worked on finishing the Inventory class. added some more item subclasses, potion and weapon. potions will be usable items 
 * 		that can apply different effects. as of right now, i can have infinite items/potions/weapons, but i may hardcode in my items
 * 		 in the future and store them in a file or something, that way i can have more control and so i can make items do different things. 
 * 		Also added the GameManager finally. as of right now it doesn't do much, but you can tell it when the game is supposed to end, 
 * 		and set the Playable Character. i might go back and redo these update logs into a form of:
 * 			+: feature
 * 			-: removed thing
 * 			^: rewrite
 * 			B: bug fix
 * 			R: move/rename something.
 * 		might make it display that somewhere too. who knows. if you are reading this, it didn't happen (yet) or are looking at older 
 * 		versions of my code (please don't do that, its ugly in here) -Edit 12/8 or ive done it and am just too lazy to remove these comments (whoops)
 * 11/25 its 3 weeks in and i finally added a menu! wooooooot! so much PROGRESS. current menu options: play, requirements, update log, quit.
 * 		ive tried adding a way to detect the arrow keys in a console app, but from hours of searching through stack overflow, that may not be possible....
 * 
 * 
 * 
 * 
 * 
 */
package FinalProject;

import Character.*;
import Character.Character;
import Exceptions.*;
import GameManager.GameManager;
import Items.*;
import Utils.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SuppressWarnings("unused")
/**
 * 
 * @author Christian Pilley & Kallie Mendoza
 *
 */
public class Main{
	static char[] cs = {'[',']',' ',' ',' ',' ',' ',' '};
	static Scanner scan = new Scanner(System.in);
    public static void main(String...strings){
    	int choice = 0;
    	do {
    	Menu();
    	
    	choice = selector();
    	
    	}while(choice != 1);
    }
    
    
    public static int selector() {
    	
    	char let = ' ';
    	if(scan.hasNextLine()) {
    		let = scan.nextLine().toLowerCase().toCharArray()[0];
    	}else {
    		
    	}
    	switch(let) {
    	case 'a':
    		System.out.print("Please enter a name for your Character + \n>>>");
    		String name = scan.nextLine();
    		CharacterInventory c = new CharacterInventory();
    		try {
				c.setDefaultInventory();
			} catch (InventoryTooSmallException e) {e.printStackTrace();}
			
    		int health = 20;
    		Location loc = null;
    		boolean isNPC = false;
    		GameManager.play(new Character(c, health, name, loc, isNPC));
    		return 0;
    	case 'b':
    	
    		displayRequirements();
    		return 0;
    	case 'c':
    	
    		displayUpdateLogs();
    		return 0;
    	
    	case 'd':
    	
    		return 1;
    	case 't': 
    		//This method is purely just for testing stuff. i will just fill this method with stuff that i want to test, like new features.
    		
    		testingEnvironment();
    		return 1;
    	default:
    		
    		System.out.println("Please enter correct input");
    		return 0;
    	}
    }

    private static void testingEnvironment() {
		
		
	}
	private static void displayUpdateLogs() {
		File[] updates = getFilesFromFolder("Updates");
		for(File f : updates) {
			try {
				Scanner up = new Scanner(f);
				System.out.println(f.getName());
				while(up.hasNext()) {
					System.out.println(up.nextLine());
				}
				up.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void displayRequirements() {
    	File req = new File("Resources\\Requirements.txt");
		try {
			Scanner scan = new Scanner(req);
			while(scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Displays a 1 dimensional array of items.
	 * @param items
	 */
	public static void display1DItemArray(Item[] items) {
    	for(Item i : items) {
    		System.out.println(i);
    	}
    }
	/**
	 * Displays the Main Menu
	 */
    public static void Menu(){
    	System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    	System.out.println("Welcome!");
    	System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    	System.out.println("  A] Play");
    	System.out.println("  B] Requirements");
    	System.out.println("  C] Update Log");
    	System.out.println("  D] Quit");
    	System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    	
    }
    /**Gets all the files from a specific folder.
     * 
     * @param Folder - the folder being looked in
     * @return Files[] - the files being in the folder
     */
    public static File[] getFilesFromFolder(String Folder) {
    	
		return new File("Resources\\" + Folder).listFiles();
    }
    /**
     * Displays  strings.
     * @param strings - strings to be displays
     */
    public static void displayStrings(String...strings) {
    	for(String s : strings) {
    		System.out.println(s);
    	}
    }
    
}
// Dont ask me why this is here, i wouldnt be able to tell you.
/*
 +----+----+----+----+----+----+----+----+
 | bC | bk | bB | bQ | bK | bB | bk | bC |
 +----+----+----+----+----+----+----+----+
 | bP | bP | bP | bP | bP | bP | bP | bP |
 +----+----+----+----+----+----+----+----+
 |    |    |    |    |    |    |    |    |
 +----+----+----+----+----+----+----+----+
 |    |    |    |    |    |    |    |    |
 +----+----+----+----+----+----+----+----+
 |    |    |    |    |    |    |    |    |
 +----+----+----+----+----+----+----+----+
 |    |    |    |    |    |    |    |    |
 +----+----+----+----+----+----+----+----+
 | wP | wP | wP | wP | wP | wP | wP | wP |
 +----+----+----+----+----+----+----+----+
 | wC | wk | wb | wQ | wK | wb | wk | wC |
 +----+----+----+----+----+----+----+----+
 
 
 
 
 
 */















