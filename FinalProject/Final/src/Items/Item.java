package Items;

import static Items.Item.Rarity.common;

public class Item {

	protected enum Rarity {
		common, rare, epic, legendary
	}

	protected String name;
	protected int count;
	protected Rarity rarity;
	protected float value;

	public Item() {

	}

	public Item(String name) {
		this.name = name;
		this.count = 1;
	}

	public Item(String name, int count) {
		this.name = name;
		this.count = count;
		value = 0;
		rarity = common;
	}

	public String getItemName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean equals(Item item) {
		return item.name.equals(this.name) && item.rarity == this.rarity && item.value == this.value;
	}

	public void setNull() {
		name = "";
		value = 0;
		rarity = common;
		count = 0;

	}

}
