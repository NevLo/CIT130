
package firstloop;

import java.util.Scanner;


public class FirstLoop {

    public static void main(String[] args) {
        int count = 0;
        System.out.print("Count is ");
        while(count < 10){     
            System.out.print(count + " ");
            ++count;
            
        }
        System.out.println();
        Scanner input = new Scanner(System.in);
        double total = 0.00;
        double item = 0.00;
        
        System.out.println("Please scan next item (0 to end)");
        item = Double.parseDouble(input.next());
        
        while(item > 0.00){
            total += item;
            System.out.println("Please scan next item (0 to end)");
            item = Double.parseDouble(input.next());
        }
        System.out.println(String.format("Please collect %.2f $", total));
        
    }
    
}
