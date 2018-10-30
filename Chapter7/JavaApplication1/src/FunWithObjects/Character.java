package FunWithObjects;

public class Character {

    private String name;
    private double height;
    private int hitPoints;
    private boolean isEvil;

    //Default Constructor
    public Character() {

        isEvil = true;
    }

    public Character(String n, double h, int hp, boolean evil) {
        name = n;
        setHeight(h);
        hitPoints = hp;
        isEvil = evil;
    }

    //A method to display info
    public void displayMethod() {
        System.out.println("Character name is ".concat(name));
        System.out.println("Character height is ".concat(Double.toString(height)));
        System.out.println("Character hitPoints are ".concat(Integer.toString(hitPoints)));
        System.out.println("Character alignment is ".concat(Boolean.toString(isEvil)));
    }

    // Modify stuff
    public void setName(String n) {
        name = n;
    }

    public void setHeight(double d) {
        if (d < 1.0) {
            height = 1.0;
        }else{
            height = d;
        }
    }

    public void setHP(int hp) {
        if (hp > 25) {
            hitPoints = 25;
        }else{
            hitPoints = hp;
        }
    }

    public void setAlignment(boolean e) {
        isEvil = e;
    }

    public String getName(){
        return name;
    }
    public double getHeight(){
        return height;
    }
    public int getHP(){
        return hitPoints;
    }
    public boolean getAlignment(){
        return isEvil;
    }
    
}
