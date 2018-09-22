package me.pilley.christian.changeconverter;
//name: Christian Pilley
//date: 9-22-18 :: 03:20am 
//desc: adds change
import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static void main(String... args) {
		System.out.print("Please enter number of quarters :");
		int numQ = input.nextInt();
		System.out.print("Please enter number of dimes: ");
		int numD = input.nextInt();
		System.out.print("Please enter number of nickles: ");
		int numN = input.nextInt();
	
		double amount = numQ * .25 + numD * .1 + numN * .05;
		System.out.println("The amount of money you have is $" + amount);
	
	}
}
