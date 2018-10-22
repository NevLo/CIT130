
package textforloops;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextForLoops {

  
    public static void main(String[] args) throws IOException{
        File file = new File("Data.dat");
        Scanner scan = new Scanner(file);
        
        while(scan.hasNext()){
            int num = scan.nextInt();
            for(int i =0; i < num; i++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
