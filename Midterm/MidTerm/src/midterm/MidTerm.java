/*
NAME: Christian Pilley
DATE: 10/22/18 18:09
DESC: Midterm CIT 130 FA2018


 */
package midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class MidTerm {

    public static void main(String[] args) throws FileNotFoundException {
        //gets user input from console
        Scanner input = new Scanner(System.in);
        //generates random numbers
        Random rand = new Random();
        System.out.print("What is your name\n>>> ");
        //the users name is stored here
        String name = input.nextLine();
        //user choice. declared here so it can be used outside the do 
        //segment, and in the while arguements
        int choice;
        do {

            System.out.println("-=-=-=-= Hello " + name + "! =-=-=-=-\n");
            System.out.println("1 - Create Nickname");
            System.out.println("2 - Test your IQ");
            System.out.println("3 - Display a table");
            System.out.println("4 - Read from a file");
            System.out.println("5 - Exit");

            System.out.println("\n Please enter your selection");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print(">>> ");
            choice = input.nextInt();

            switch (choice) {

                case 1: {
                    //<editor-fold defaultstate="open" desc="Case 1">
                    System.out.println("Current name: " + name);
                    //generate the nick name as its own variable before
                    //assigning it to name
                    String nick = "$";
                    nick += name.charAt(0);
                    nick += name.charAt(name.length() - 1);
                    //random 3 digit number
                    int r = (int) (rand.nextDouble() * 1000);
                    nick += r;
                    nick += name.length();
                    System.out.println("Your new Nickname: " + nick);
                    name = nick;
                    break;
                }
                //</editor-fold>
                case 2: {
                    //<editor-fold defaultstate="open" desc="Case 2">
                    //used to store the Users UQ
                    int IQ;
                    //stores operand number 1
                    int num1 = rand.nextInt(50);
                    //stores operand number 2
                    int num2 = rand.nextInt(50);
                    //the sum of the operands
                    int sum = num1 + num2;
                    System.out.println("What is the sum of ["
                            + num1 + "] and [" + num2 + "]?");
                    //the users guess as to what sum is
                    int ans = input.nextInt();
                    if (sum == ans) {
                        System.out.println("Great job!");
                        IQ = 100 + sum;
                    } else {
                        System.out.println("No, the answer was... " + sum);
                        IQ = 10 + sum;
                    }
                    System.out.println("Your IQ is " + IQ + "!");

                    break;
                }
                //</editor-fold>
                case 3: {
                    //<editor-fold defaultstate="open" desc="Case 3">
                    System.out.print(name + ", could you enter a letter? \n>>> ");
                    input.nextLine();
                    //the users input for a letter
                    String let = input.nextLine();

                    System.out.print(name + ", could you enter a number between"
                            + " 1 and 10? \n>>> ");
                    // the users input for a number between 1 and 10
                    int num = Integer.parseInt(input.next());

                    num = (num >= 1 ? (num <= 10 ? num : 10) : 10); //This is one statement.
                    System.out.println("");
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            System.out.print(let + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
                }
                //</editor-fold>
                case 4: {
                    //<editor-fold defaultstate="open" desc="Case 4">
                    //input file
                    File file = new File("numbers.txt");
                    
                    //this opens the file for reading
                    Scanner fileInput = new Scanner(file);
                    //sum of all numbers in the file.
                    int sum = 0;
                    while(fileInput.hasNext()){
                       sum += fileInput.nextInt();
                    }
                    System.out.println("\nThe sum of all the numbers in " 
                            + file.getName() + " is " + sum +"\n");
                    fileInput.close();
                    break;
                }
                //</editor-fold>
                case 5: {
                    //<editor-fold defaultstate="open" desc="Case 5">
                    System.out.println("Thanks for playing! Please come back again!");
                    break;
                }
                //</editor-fold>
                default: {
                    //<editor-fold defaultstate="open" desc="Default Case">
                    System.out.println("\n[INVALID INPUT] Please try again.\n");
                    break;
                }
                //</editor-fold>
            }

        } while (choice != 5);
        input.close();
    }

}
