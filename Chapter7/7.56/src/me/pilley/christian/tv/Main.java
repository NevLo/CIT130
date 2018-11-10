package me.pilley.christian.tv;

public class Main {
	public static void main(String[] args) {
		Television TV1 = new Television();
		TV1.setBrand("Sony");
		TV1.setPrice(4000);
		Television TV2 = new Television("Panasonic", 5000);
		Television TV3 = TV2;

		System.out.println("System.out.println(TV1)");
		System.out.println(TV1);
		System.out.println("System.out.println(TV2)");
		System.out.println(TV2);
		System.out.println("System.out.println(TV3)");
		System.out.println(TV3);
		System.out.println();
		System.out.println("TV1.equals(TV2)");
		System.out.println(TV1.equals(TV2) ? "These Tv's are the same" : "These Tv's are not the same");
		System.out.println("TV3.equals(TV2)");
		System.out.println(TV3.equals(TV2) ? "These Tv's are the same" : "These Tv's are not the same");
		
	}
}
