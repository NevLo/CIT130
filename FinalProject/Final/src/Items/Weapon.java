package Items;
import Utils.Rarity;
/**
 * 
 * @author Christian Pilley & Kallie Mendoza
 *
 */
public class Weapon extends Item {
	public int damage;
	public Weapon(String string) {
		name = string;
		value = 10;
		count = 1;
		rarity = Rarity.rare;
		damage = 10;
	}
	public Weapon(String string, int damage) {
		name = string;
		value = 10;
		count = 1;
		rarity = Rarity.rare;
		this.damage = damage;
	}
	public Weapon(String string, int damage, Rarity rarity) {
		name = string;
		value = 10;
		count = 1;
		this.rarity = rarity;
		this.damage = damage;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Weapon) {
			Weapon temp = (Weapon) obj;
			return name.equals(temp.name) 
					&& value == temp.value
					&& rarity == temp.rarity
					&& damage == temp.damage;
		}
		return false;
		
	}
	public int getDamage() { return damage; }

}
