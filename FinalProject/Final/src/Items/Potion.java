package Items;

import Utils.Effect;

public class Potion extends Item {
	private Effect effect;
	
	
	
	
	public Potion(){
		
	}
	
	public int getCount()
	{
		return super.count;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	
	
}