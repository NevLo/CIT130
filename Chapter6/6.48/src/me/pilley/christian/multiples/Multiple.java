package me.pilley.christian.multiples;

public class Multiple {
	public static void main(String[] args) {
		for (int i = 33, counter = 0; i <= 97; i++) {
			if (i % 7 == 0) {
				counter++;
			}
			if (i == 97) {
				System.out.println(counter);
			}
		}
	}
}
