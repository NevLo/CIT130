package Character;



import java.util.ArrayList;





public class Inventory {
        public enum Sort{Name, Rarity, Value, StackSize};
        private final int DEFAULT_INVENTORY_SIZE = 10;
	
	@SuppressWarnings("serial")
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
		Inventory = new ArrayList<>();
		for(int i = 0; i < DEFAULT_INVENTORY_SIZE; i++) {
			Inventory.add(new ArrayList<>());
		}
		size = DEFAULT_INVENTORY_SIZE;
		
	}
	
	public void setDefaultInventory() {
		for(int i = 0; i < DEFAULT_INVENTORY.size(); i++) {
			Inventory.get(0).add(DEFAULT_INVENTORY.get(i));
			numItemStacks++;
		}
		
	}
        /**
         * 
         * @param item 
         */
        
	public void addToInventory(Item item) {
            if(numItemStacks == size*size) return;
            for(int i = 0; i < Inventory.size(); i++){
                for(int j = 0; j < Inventory.get(i).size(); j++){
                    
                    if(Inventory.get(i).get(j).equals(item)){
                        Item temp = Inventory.get(i).get(j);
                        temp.setCount(temp.getCount() + item.getCount());
                    }
                }
            }
	}
        
        
        /**
         * 
         * @param i
         */
        public void addToInventory(Inventory i){
            for(int x = 0; x < this.Inventory.size(); x++){
                for(int y = 0; y < this.Inventory.get(x).size(); y++){
                    if(Inventory.get(x).get(y).equals(i.Inventory.get(x).get(y))){
                        Item temp = Inventory.get(x).get(y);
                        temp.setCount(temp.getCount() + i.Inventory.get(x).get(y).getCount());
                    }
                }
            }
        }
        
        
        
        
	/**
	 * Uses System.out.println() to display to the screen
	 */
	public void displayInventory() {
                if(numItemStacks == 0){
                    System.out.println("Empty Inventory");
                    return;
                }
		int counter = 0;
		for(int i = 0; i < Inventory.size(); i++) {
			for(int j = 0; j < Inventory.get(0).size(); j++) {
				if(Inventory.get(i).get(j) == null) continue;
				Item temp = Inventory.get(i).get(j);
				System.out.print(temp.getItemName() +" x" + temp.getCount()+ "   ");
				counter++;
				if(counter == numItemStacks) {
                                        System.out.println("");
					return;
				}
			}
			System.out.println();
		}
	}
        public void clearInventory(){
            for(int i = 0; i < size; i++){
                Inventory.get(i).clear();
            }
            numItemStacks = 0;
        }
        public boolean searchForItem(Item item){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(item.equals(Inventory.get(i).get(j)))
                        return true;
                }
            }
            return false;
        }
        public void sortInventory(Sort sort){
            switch(sort){
                case Name:
                case Value:
                case Rarity:
                case StackSize:
            }
        }
	
	
	
}
