package me.pilley.christian.daverage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Average {

	public static void main(String[] args) throws IOException {
		File inputFile = new File("Input.txt");

		Scanner file = new Scanner(inputFile);
		int counter = 0;
		double avg = 0;
		while (file.hasNextDouble()) {
			avg += file.nextDouble();
			counter++;
		}
		avg /= counter;
		System.out.println("The average of all the values in Input.txt is: " + avg);
		file.close();
	}
}
