package me.pilley.christian.password;
//name: Christian Pilley
//date: 9-22-18 :: 03:20am 
//desc: finds the number of characters of the shortest password.
import java.util.Scanner;
public class Main {
	public static Scanner input = new Scanner(System.in);
	public static void main(String... args) {
		String pass1, pass2;
		System.out.print("Please enter the first word: ");
		pass1 = input.nextLine();
		System.out.print("Please enter the second word: ");
		pass2 = input.nextLine();
		int passCount = Math.min((pass1.length()), (pass2.length()));
		System.out.println(passCount);
	}
}
