package me.pilley.christian.factorial;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a number\n>>>");
		int num = in.nextInt();
		for (int result = 1; num > 0; num--) {
			result *= num;
			if (num == 1) {
				System.out.println(result);
			}
		}
		in.close();
	}
}
