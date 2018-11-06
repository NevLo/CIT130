package pizzastore;

public class Pizza {
    /**
     * Enum sizes is used for demonstration purposes
     */
    public enum Sizes{Small, Medium, Large, ExtraLarge};
    
    private Sizes size;
    private boolean extraCheese;
    private int numberOfSlices;
    
    public static double totalPrice;
    
    
    //public getters
    public Sizes getSize(){
        return size;
    }
    public boolean getExtraCheese(){
        return extraCheese;
    }
    public int getNumberOfSlices(){
        return numberOfSlices;
    }
    //public setters
    public void setSize(Sizes size){
        this.size = size;
    }
    
    public void setExtraCheese(boolean extraCheese){
        this.extraCheese = extraCheese;
    }
    public void setNumberOfSlices(int numberOfSlices){
        this.numberOfSlices = numberOfSlices;
    }
    
    /**
     * Returns a string with pizza info
     * @return String
     */
    
    @Override
    public String toString(){
        //I like .concat(); dont hate me.
        return "Size: " + size.ordinal() + ""
                        .concat("\nSlices: ")
                        .concat(Integer.toString(numberOfSlices))
                        .concat("\nExtra Cheese: ")
                        .concat(Boolean.toString(extraCheese))
                        .concat("\n");                    
    }
    /**
     * My dog has flees
     * @param obj Object class rules!!!
     * @return boolean dude.
     */
    @Override
    public boolean equals(Object obj){
        
        if(obj instanceof Pizza){
            Pizza object = (Pizza) obj;
            return this.size == object.size 
                && this.extraCheese == object.extraCheese 
                && this.numberOfSlices == object.numberOfSlices;
        }else{
            return false;
        }
    }   
    public static void updateTotal(double amt){
        totalPrice += amt;
    }
    
}
