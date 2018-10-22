
package multtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MultTable {

    public static void main(String[] args) throws FileNotFoundException {
       File file = new File("Data.dat");
       Scanner scan = new Scanner(file);
       int factor = 0;
       System.out.println("Multiplication Table:");
       
       
       while(scan.hasNext()){
           factor = scan.nextInt();
       }
       scan = new Scanner(file);
       while(scan.hasNext()){
           int temp = scan.nextInt();
           for(int x = 1; x <= factor; x++){
               System.out.print(String.format("%03d",x * temp) + " | ");
           }
           System.out.println("");
       }
           
    }
    
}
