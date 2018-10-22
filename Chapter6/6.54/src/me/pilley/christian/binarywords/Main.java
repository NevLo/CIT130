package me.pilley.christian.binarywords;

import java.util.Scanner;
/*
 NAME: Christian Pilley
  
 DESC: 54. Write a program that inputs a word representing a binary number 
       (0s and 1s). First, your program should verify that it is indeed a 
       binary number, that is, the number contains only 0s and 1s. If that 
       is not the case, your program should print a message that the number
       is not a valid binary number. Then, your program should count how many
       1s are in that word and output the count. 
  
  DATE: 10/21/2018 :: 2208
 */

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a word in binary\n>>>");
		String bin = input.nextLine();
		int oneCount = 0;
		for(int i = 0; i < bin.length(); i++) {
			char c = bin.charAt(i);
			if(c != '0' && c != '1') {
				System.out.println("You have entered an invalid value!");
			}else if(c == '1') {
				oneCount++;
			}else {
				continue;
			}
		}
		System.out.println("The number of 1's in " + bin + " is: " + oneCount);
		input.close();
		
		
	}
}
