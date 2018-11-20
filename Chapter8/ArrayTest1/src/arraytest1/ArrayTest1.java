package arraytest1;


import java.util.Random;

public class ArrayTest1 {

    public static void main(String[] args) {
        /*
        int[] numbers = {-1, 0, 12, 111, -178, 24,24,0, 2};
        String[] names = {"Beth", "Brandy", "Tom", "Frank"};
        String[] names2 = {"Topher"};
        Random rand = new Random();
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt();
        }
        displayArray(names);
        displayArray(names2);
        
        names = names2;
        displayArray(names);
        
        
        
        for(int i = 0; i < numbers.length; i++){
            System.out.println(i + " - " + numbers[i]);
        }
*/
        Auto[] autos = new Auto[3];
        autos[0] = new Auto("Camaro");
        autos[1] = autos[0];
        autos[2] = new Auto();
        autos[0] = autos[2];
        for(Auto a : autos){
            System.out.println(a.getModel());
        }
    }

    private static void displayArray(String[] items) {
        for(String n : items){
            System.out.println(n);
        }
        System.out.println("*******************");
    }
   
    
}
