/*
Name: Christian Pilley
Desc: Final project for CIT 130
Modification History:

Author          Date            Change
------          ----            ------
Christian P     11/5            1.0 Started project.
Christian P     11/5            1.1 Added menu, 
*/
package finalproject;

import java.awt.event.KeyListener;
import java.util.Scanner;
/**
 *
 * @author Christian_Pilley
 */
public class FinalProject {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       boolean running = true;
        do{
            
            Menu();
            running = false;
        }while(running);
    }
    public static void Menu(){
        char aOpenBrace  = '[';
        char bOpenBrace  = ' ';
        char cOpenBrace  = ' ';
        char dOpenBrace  = ' ';
        char aCloseBrace = ']';
        char bCloseBrace = ' ';
        char cCloseBrace = ' ';
        char dCloseBrace = ' ';
        
        System.out.println("\tWelcome to NevLo-Game-Co!");
        System.out.println("------------------------------------------");
        System.out.println("\t" + aOpenBrace + "A" + aCloseBrace + "\tNew Game");
        System.out.println("\t" + bOpenBrace + "B" + bCloseBrace + "\tContinue Game");
        System.out.println("\t" + cOpenBrace + "C" + cCloseBrace + "\tOptions");
        System.out.println("\t" + dOpenBrace + "D" + dCloseBrace + "\tQuit");
        
    }
    
}
