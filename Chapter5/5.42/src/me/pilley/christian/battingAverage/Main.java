package me.pilley.christian.battingAverage;

import java.util.Scanner;
//Name:Christian Pilley
//Desc:Batting average calculator
//Date: 10/5/18/ :: 03:10 

public class Main {
		
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int hits;
		int atBats;
		System.out.println("Please enter the number of hits the player hit: ");
		System.out.print(">>>");
		hits = input.nextInt();
		System.out.println("Please enter the number of at-bats the player had: ");
		System.out.print(">>>");
		atBats = input.nextInt();
		
		float average = (1.0f * hits) / (1.0f * atBats); 
		//System.out.println(average);
		System.out.println
		(((average < .3f)? "This Player is not eligible for the All Stars Game" : "This player is eligible for the All stars game."));	
		input.close();
	}
}
