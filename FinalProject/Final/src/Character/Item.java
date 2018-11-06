package Character;

public class Item {
	private String name;
	private int count;
	
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
