package me.pilley.christian.squareroots;

import java.util.Scanner;
//Name: Christian Pilley
//Date: 10/13/18 :: 1:13
//Desc: Calculates how many times a square root can be done before it drops below 1.01

public class SquareRoots {
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		boolean correctInput = false;
		int inputInteger = 0;
		//System.out.println("Enter a value that is greater than 10.");
		while(!correctInput) {
			System.out.println("Enter a value that is greater than 10.");
			if(!input.hasNextInt()) {
			
			@SuppressWarnings("unused")
			String temp = input.nextLine();
			}else {
				inputInteger = input.nextInt();
				if(inputInteger > 10) {
					correctInput = true;
				}
				
			}
		
		}
		System.out.println("Input: " + inputInteger);
		double result = Math.sqrt(inputInteger);
		int counter = 1;
		while(result >= 1.01) {
			result = Math.sqrt(result);
			//System.out.print(" " + result);
			counter++;
		}
		System.out.println("The square root operation was preformed " + counter + " times!");
		
	}
}
