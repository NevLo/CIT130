package GameManager;
import java.util.Scanner;

import Character.Character;
import FinalProject.Main;
import Items.Item;
@SuppressWarnings("unused")
public class GameManager {
	private static int textSpeed = 50;
	private static boolean alive;
	private static int points;
	private static Character mainCharacter;
	private static Scanner scanner;
	private static int Offset = 0;
	private static Character getCharacter() {
		return mainCharacter;
	}
	public static void addPoints(int p) {
		points += p ;
	}
	
	
	public static void end() {
		alive = false;
		String p = String.valueOf(points);
		String uL = "You Lose!";
		System.out.println(uL);
		System.out.println("Points: " + p);
	}

	public static void setPlayer(Character character) {
		mainCharacter = character;	
	}
	
	public static void play(Character m) {
		alive = true;
		mainCharacter = m;
		points = 0;
		int count = 0;
		scanner = new Scanner(System.in);
		fancyText("You are a poor medieval farmer who recently came upon a quest.");
		fancyText("The King's wife has gone missing and there is a reward.");
		fancyText("This reward is enough to feed your starving family for life.");
		
		while(alive) {
			count = runEvent(count);
			
		}
	}
	

	private static void fancyText(String string) {
		for(int i = 0; i < string.length(); i++) {
			System.out.print(string.charAt(i));
			try {
				Thread.sleep(textSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
	}
	public static void win() {
		
	}
	private static int runEvent(int count) {
		boolean correctInput = false;
		int amountOfGold = mainCharacter.getInventory().itemAt(mainCharacter.getInventory().searchForItem(new Item("Gold"))).getCount();
		switch(count) {
		case 0:
			fancyText("You are in the town center, where do you wish to go " + mainCharacter.getName() + "?");
			do {
				System.out.println("A] Home\n"+
								   "B] Market\n"+
								   "C] Black Forest");
				char in = scanner.nextLine().toLowerCase().toCharArray()[0];
				if(in != 'a' && in != 'b' && in != 'c') {
					System.out.println("Enter a correct choice.");
				}else if(in == 'a') {
					return 1;
				}else if(in == 'b'){
					return 2;
				}else {
					return 3;
				}
			}while(!false);
		case 1:
			
			fancyText("You have decided to walk home.");
			fancyText("When you arrive your wife is hanging up laundry to dry,\nyour 4 kids are playing, and the baby is asleep.");
			fancyText("The crops are dead and the dirt is dry. what do you wish to do "+ mainCharacter.getName() +"?");
			do {
				System.out.println("A] Help with Chores\n"+
								   "B] Play with kids\n"+
								   "C] Take care of the baby\n"+
								   "D] Check the crops"+
								   "E] Head back towards the town center");
				char in = scanner.nextLine().toLowerCase().toCharArray()[0];
				if(in != 'a' && in != 'b' && in != 'c' && in != 'd' && in != 'e') {
					System.out.println("Enter a correct choice.");
				}else if(in == 'a'){
					return 4;
				}else if(in == 'b'){
					return 5;
				}else if(in == 'c'){
					return 6;
				}else if(in == 'd'){
					return 7;
				}else {
					return 0;
				}
				
			}while(!false);
		case 2:
			
			fancyText("You decide to head to the Market");
			fancyText("You have " + amountOfGold + " on you, and see 3 stands infront of you.");
			fancyText("The Armory sells armor and weapons."
					+ "\nThe Butchery sells food, animals, seeds, and farming equipment."
					+ "\nThe Apothecary sells potions and herbs");
			fancyText("where would you like to go "+ mainCharacter.getName() +"?");
			do {
				System.out.println("A] Armory\n"+
								   "B] Butchery\n"+
								   "C] Apothecary\n"+
								   "D] Return to the town center");
				char in = scanner.nextLine().toLowerCase().toCharArray()[0];
				if(in != 'a' && in != 'b' && in != 'c' && in != 'd') {
					System.out.println("Enter a correct choice.");
				}else if(in == 'a'){
					return 8;
				}else if(in == 'b'){
					return 9;
				}else if(in == 'c'){
					return 10;
				}else {
					return 0;
				}
			}while(!false);
		case 3:
			fancyText("This path is not available yet.");
			return 0;
			/*
			fancyText("You have decided to walk home.");
			fancyText("When you arrive your wife is hanging up laundry to dry,\nyour 4 kids are playing, and the baby is asleep.");
			fancyText("The crops are dead and the dirt is dry. what do you wish to do"+ mainCharacter.getName() +"?");
			do {
				System.out.println("A] Help with Chores\n"+
								   "B] Play with kids\n"+
								   "C] Take care of the baby\n"+
								   "D] Check the crops"+
								   "E] Head back towards the town center");
				char in = scanner.nextLine().toLowerCase().toCharArray()[0];
				if(in != 'a' && in != 'b' && in != 'c' && in != 'd' && in != 'e') {
					System.out.println("Enter a correct choice.");
				}else {
					return count + ((int)(in)-96);
				}
			}while(!false);
			*/
		}
		return count;
	}

}
