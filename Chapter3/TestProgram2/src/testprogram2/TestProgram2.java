
package testprogram2;

import java.util.Random;
import java.util.Scanner;
public class TestProgram2 {
    
    
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Hey! Who are you? ");
        String name = input.nextLine();
        System.out.println("Hi " + name + ", enter an int: ");
        int in = input.nextInt();
        
        int tempNum = rand.nextInt(in) + 1;
        System.out.println("Number is: " + tempNum);
        
        double result = Math.pow(in, 3);
        System.out.println(result);
    }
    
}
