package Character;



import java.util.ArrayList;





public class Inventory {
	private final int DEFAULT_INVENTORY_SIZE = 10;
	
	private final ArrayList<Item> DEFAULT_INVENTORY = new ArrayList<Item>() {{
			add(new Item("Rope", 50));
			add(new Item("Torch"));
			add(new Item("Knife"));
			add(new Item("Rations", 3));
			add(new Item("Matches", 50));
	}};
	ArrayList<ArrayList<Item>> Inventory;
	private int size;
	private int numItemStacks = 0;
	
	public Inventory() {
		Inventory = new ArrayList<ArrayList<Item>>();
		for(int i = 0; i < DEFAULT_INVENTORY_SIZE; i++) {
			Inventory.add(new ArrayList<Item>());
		}
		size = DEFAULT_INVENTORY_SIZE;
		
	}
	
	public void setDefaultInventory() {
		for(int i = 0; i < DEFAULT_INVENTORY.size(); i++) {
			Inventory.get(0).add(DEFAULT_INVENTORY.get(i));
			numItemStacks++;
		}
		
	}
	public void addToInventory(Item item) {
		
	}
	/**
	 * Uses System.out.println() to display to the screen
	 */
	public void displayInventory() {
		int counter = 0;
		for(int i = 0; i < Inventory.size(); i++) {
			for(int j = 0; j < Inventory.get(0).size(); j++) {
				if(Inventory.get(i).get(j) == null) continue;
				Item temp = Inventory.get(i).get(j);
				System.out.print(temp.getItemName() + "   ");
				counter++;
				if(counter == numItemStacks) {
					return;
				}
			}
			System.out.println();
		}
	}
	
	
	
}
