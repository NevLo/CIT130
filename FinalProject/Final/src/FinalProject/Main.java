package FinalProject;

import Character.Inventory;

public class Main {
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.setDefaultInventory();
		inv.displayInventory();
	}
}
