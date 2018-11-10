package pizzastore;

import java.text.NumberFormat;

public class PizzaStore {

    public static void main(String[] args) {
        Pizza pizzaOne = new Pizza();
        Pizza pizzaTwo = new Pizza();
        pizzaOne.setExtraCheese(true);
        pizzaOne.setNumberOfSlices(16);
        pizzaOne.setSize(Pizza.Sizes.Large);
        pizzaTwo.setSize(Pizza.Sizes.Medium);
        Pizza.updateTotal(12.094);
        Pizza.updateTotal(14.7653);
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println(formatter.format(Pizza.totalPrice));
        
        System.out.println(pizzaOne.toString());
        System.out.println(pizzaTwo.toString());
        
        
            System.out.println("Equals? ".concat(
                    Boolean.toString(pizzaOne.equals(pizzaTwo))));
        
    }
    
    public static void displayTotal(){
       
    }
    
}
