package Character;

/**
 * 
 * @author NevLo
 *
 */
public class Character {
	
	private Inventory inventory;
        private int health;
        private String name;
        private Location loc;
        private boolean npc;
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
        
        public void takeDamage(int damage, Character attacker){
            health -= damage;
            if(health <= 0){
                if(!npc){
                    //Die
                }else{
                    attacker.inventory.addToInventory(this.inventory);
                }
            }
        }
        public void setNPC(boolean npc){
            this.npc = npc;
        }
        public Character(){
            health = 10;
            inventory = new Inventory();
            inventory.setDefaultInventory();
        }
	
	
	
	
	
}
