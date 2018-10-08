package me.pilley.christian.users;
import java.util.Scanner;
// Name: Christian Pilley	
// desc: Username and password
// date: 10/5/18 :: 03:22

public class Main {
	public static void main(String[] args) {
		String user, pass;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("---------------------");
		System.out.println("ID");
		System.out.print(">>>");
		user = input.nextLine();
		System.out.println("Password");
		System.out.print(">>>");
		pass = input.nextLine();
		
		if(user.equalsIgnoreCase("admin")) {
			if(pass.equalsIgnoreCase("open")) System.out.println("Welcome.");
			else System.out.println("Wrong password");
			
		}else {
			if(pass.equalsIgnoreCase("open")) System.out.println("Wrong user ID");
			else System.out.println("Sorry, wrong ID and password");
		}
		input.close();
		
		
		
	}
}
