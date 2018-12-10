package Items;

/**
 * A nullItem, a item which is null so my inventory doesnt kill itself when
 * sorting/searching.
 *
 * @author Christian Pilley & Kallie Mendoza
 *
 */
public class NullItem extends Item {

    /**
     * Constructor
     */
    public NullItem() {
        name = "NULL";
        count = 0;
        value = 0.00F;
    }
}
