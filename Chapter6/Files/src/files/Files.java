
package files;

import java.io.File;
import java.io.IOException;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {

   
    public static void main(String[] args) throws IOException {
        
        
        File file = new File("C:\\input.txt");
        Scanner inputFile = new Scanner(file);
        while(inputFile.hasNext()){
            System.out.println(inputFile.next());
            
        }
    }
    
    
}
