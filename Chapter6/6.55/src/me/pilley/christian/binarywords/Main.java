package me.pilley.christian.binarywords;

import java.util.Scanner;
/*
 NAME: Christian Pilley
 
 DESC: 55. Perform the same operations as Question 54, with the following
       modification: If the word does not represent a valid binary number,
       the program should keep prompting the user for a new word until a word
       representing a valid binary number is input by the user.

DATE: 10/21/18 :: 2212
 */

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a word in binary\n>>> ");
		boolean ci = false;
		while (!ci) {
			String bin = input.nextLine();
			int oneCount = 0;
			int invalid = 0;
			for (int i = 0; i < bin.length(); i++) {
				char c = bin.charAt(i);
				if (c != '0' && c != '1') {
					invalid++;
				} else if (c == '1') {
					oneCount++;
				} else {
					continue;
				}
			}
			if(invalid != 0) {
				System.out.print("Please enter a valid Binary number\n>>> ");
			}else {
				ci = true;
				System.out.println("The number of 1's in " + bin + " is: " + oneCount);	
			}
			
			
		}
		input.close();
	}
}
