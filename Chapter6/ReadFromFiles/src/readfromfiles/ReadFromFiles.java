
package readfromfiles;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadFromFiles {

  
    public static void main(String[] args) throws IOException{
        File file = new File("numbers.txt");
        Scanner scan = new Scanner(file);
        File file2 = new File("input.tian");
        Scanner scan2 = new Scanner(file2);
        int min = 0; 
        int max = 0;
        
        while(scan.hasNextInt()){
            int temp = scan.nextInt();
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            
        }
        
        System.out.println("Max is " + max + "\nMin is " + min);
        
        while(scan2.hasNext()){
            System.out.println(scan2.next());
            
            
        }
        
        
        
    }
    
}
