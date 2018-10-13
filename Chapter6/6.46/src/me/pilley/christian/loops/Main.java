package me.pilley.christian.loops;

public class Main {
	public static void main(String[] args) {
		for (int i = 10, total = 0; i <= 20; total += i, i++)
			if (i != 20)
				System.out.print(i + " + ");
			else
				System.out.print(i + " = " + (total + i));

	}
}
