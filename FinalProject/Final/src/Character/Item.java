package Character;

public class Item {
	
	public enum Rarity{
		common, rare, epic, legendary
	}
	
	private String name;
	private int count;
	private Rarity rarity;
	private float value;
	public Item() {
		
	}
	public Item(String name) {
		this.name = name;
		this.count = 1;
	}
	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public String getItemName(){
		return name;
	}
	public int GetCount(){
		return count;
	}
	
	
	
	
}
