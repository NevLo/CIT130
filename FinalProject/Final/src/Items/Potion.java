package Items;

import Utils.Effect;

/**
 * A child class of Item that allows the use of special effects to happen to the
 * user.
 *
 * @author Christian Pilley, Kallie Mendoza
 *
 */
public class Potion extends Item {

    private Effect effect;

    /**
     * Default Constructor
     */
    public Potion() {

    }

    public Potion(Effect effect) {
        this.effect = effect;
        this.name = effect.toString();
    }

    /**
     * gets the count ( should be 1, but yknow. this is a entry level class so
     * it wont be).
     *
     * @return
     */
    public int getCount() {
        return super.count;
    }

    /**
     * Gets the effect of the potion.
     *
     * @return
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Sets the effect of the potion.
     *
     * @param effect
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

}
