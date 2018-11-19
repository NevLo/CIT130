package Character;

import java.util.ArrayList;

import Items.Item;
@SuppressWarnings("unused")
public class ChestInventory extends Inventory{
	private final int DEFAULT_WIDTH = 8;
	private final int DEFAULT_HEIGHT = 5;
	private int randomGold() {
		return (int)(Math.random() * 100);
	}
	
	private final Item[] DEFAULT_INVENTORY = new Item[] {
			new Item(GOLD, randomGold())
	};
	@Override	
	public void setDefaultInventory() {
		clearInventory();
		
	}
	@Override
	public void addToInventory(Item item) {
		// TODO Auto-generated method stub
		
	}
	
}
