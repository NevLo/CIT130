package me.pilley.christian.hellon;

import java.util.Scanner;

public class NWorld {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number\n>>>");
		for (int i = 0, num = input.nextInt(); i < num; i++) {
			System.out.println("Hello World!");
		}
		input.close();
	}
}
