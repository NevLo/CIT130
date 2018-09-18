// Names: [Christian Pilley, Kallie Mendoza Monzon]
// Desc: 3.16 in the book
// Date: 9/17/2018 :: 20:05
package pkg3.pkg16;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();
    public static final int CURRENT_YEAR = 2018;
    public static final double LIFE_EXPECTANCY = 78.94; 
    
    
    public static void main(String[] args) {
        
        System.out.print("Hello! What is your name? ");
        String name = input.nextLine();
        System.out.println("Hi there, " + name + ". You look very nice today");
        System.out.println("There are " + name.length() + " characters in your name.");
        DecimalFormat pForm = new DecimalFormat("0.0%");
        System.out.println("What is the year you were born in?");
        int year = input.nextInt();
        int age = CURRENT_YEAR - year;
        
        System.out.println("You are going to be " + age + " years old this year.");
        double percentAge = age / LIFE_EXPECTANCY;
        System.out.println("You are roughly " + pForm.format(percentAge) + " of the way through life! Congradulations!");
        
        int num = rand.nextInt(20) + 1;
        
        System.out.print("I have generated a random number between 1 and 20, please, take a guess at what my number is! ");
        int guess = input.nextInt();
        int difference = Math.abs(num - guess);
        System.out.println("The number was " + num + "!");
        System.out.println("You were " + difference + " numbers away!");
        
        
        
    }
    
}
