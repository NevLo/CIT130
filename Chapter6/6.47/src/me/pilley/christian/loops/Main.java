package me.pilley.christian.loops;

public class Main {
	public static void main(String[] args) {

		for (int num = 1, i = 3; i <= 7; num *= i, i++)
			if (i != 7)
				System.out.print(i + " * ");
			else
				System.out.print(i + " = " + num * i);
	}

}
