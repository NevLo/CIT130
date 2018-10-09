package inputchecking;

import java.util.Scanner;

public class InputChecking {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a double\n>>>");
        while (!input.hasNextDouble()) {
            System.out.println("No");
             System.out.print("Please enter a double\n>>>");
             String temp = input.nextLine();
        }
        double temp = input.nextDouble();
        
        System.out.println("Circumference: " + temp * 3.14159);
        
    }

}
