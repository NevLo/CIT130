package Character;

import java.util.ArrayList;
import java.util.Arrays;

import Exceptions.InventoryTooSmallException;
import Items.Item;
import Items.NullItem;
import Utils.intDuo;

public abstract class Inventory {
	//NEW STUFF --------------------------------------------------------------------------------------------
	protected Item[][] inv;
	protected enum Sort {
		Name, Rarity, Value, StackSize
	};
	
	protected final String ROPE = "Rope";
	protected final String TORCH = "Torch";
	protected final String KNIFE = "Knife";
	protected final String RATIONS = "Rations";
	protected final String MATCHES = "Matches";
	protected final String GOLD = "Gold";
	protected final String EMPTY_INVENTORY = "Empty Inventory";
	
	
	protected int width;
	protected int height;
	protected int numItemStacks = 0;
	
	public abstract void setDefaultInventory() throws InventoryTooSmallException;
	
	public abstract void addToInventory(Item item);
	
	public void clearInventory() {
		for (int i = 0; i < height; i++) {
			Arrays.fill(inv[i], new NullItem());
		}
		numItemStacks = 0;
	}
	
	public intDuo searchForItem(Item item) {
		for(int i = 0; i < height;i++) {
			for(int j = 0; j < width; j++) {
				if(inv[i][j].equals(item)) {
					return new intDuo(i, j);
				}
			}
		}
		return new intDuo(-1, -1);
	}
	public boolean HasItem(Item item) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (inv[i][j].equals(item))
					return true;
			}
		}	
		return false;
	}
	public void displayInventory() {
		if (numItemStacks == 0) {
			System.out.println(EMPTY_INVENTORY);
			return;
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (inv[i][j] instanceof NullItem)
					continue;
				Item temp = inv[i][j];
				System.out.print(temp.getItemName() + " x" + temp.getCount() + "   ");
			}
			System.out.println();
		}
	}
	public void addToInventory(Inventory i) {
		
	}
	
	public Item[] to1DArray() {
		Item[] temp = new Item[width * height];
		int i = 0;
		for(int j = 0; j < height; j++) {
			for(int k = 0; k < width; k++) {
				temp[i] = inv[j][k];
				i++;
			}
		}
		return temp;
	}

}
