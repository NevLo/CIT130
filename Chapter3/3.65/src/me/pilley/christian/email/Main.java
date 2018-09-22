package me.pilley.christian.email;
//name: Christian Pilley
//date: 9-22-18 :: 03:20am 
//desc: Substrings some emails.



import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static void main(String...strings) {
		System.out.print("Please enter an email address: ");
		String hillarysEmails = input.nextLine();
		int at = hillarysEmails.indexOf("@");
		String email = hillarysEmails.substring(0, at);
		String domain = hillarysEmails.substring(at + 1, hillarysEmails.length());
		System.out.println("Username: " + email);
		System.out.println("Domain: " + domain);
	}
}
