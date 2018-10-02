
package flowandcontrol2;

import java.util.Scanner;


public class FlowAndControl2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your letter grade: ");
        char userInput = input.next().toLowerCase().charAt(0);
        
        
        float low, high;
        switch(userInput){
            
            case 'a':
                low = 90.0f;
                high = 100;
                break;
            case 'b':
                low = 80.0f;
                high = 89.99f;
                break;
            case 'c':
                low = 70.0f;
                high = 79.99f;
                break;
            case 'd':
                low = 60.0f;
                high = 69.99f;
                break;
            default:
                low = 0;
                high = 59.99f;
                break;
        }
        System.out.println("Range of " + userInput + ": " + low + " - " +high);
       
       
    }
    
}
