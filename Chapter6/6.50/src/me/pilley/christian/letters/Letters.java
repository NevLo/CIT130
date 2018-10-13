package me.pilley.christian.letters;

import java.util.Scanner;

public class Letters {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word\n>>>");
		String word = input.nextLine();
		for (int i = 0; i < word.length(); i++) {
			System.out.print(word.charAt(i) + " ");
		}
		input.close();
	}

}
