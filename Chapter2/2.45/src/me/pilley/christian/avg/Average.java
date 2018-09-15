package me.pilley.christian.avg;
//name: Christian Pilley
//desc: Calculates the (rough) average of 4 integers
//date: 9/14/2018 :: 20:06

import java.util.*;
public class Average {
	
	public static ArrayList<Integer> nums = new ArrayList<Integer>();
	public static void main(String[] args) {
		nums.add(1);
		nums.add(7);
		nums.add(9);
		nums.add(34);
		System.out.println(nums);
		int avg = 0;
		for(int i = 0; i < nums.size(); i++) {
			avg += nums.get(i);
		}
		avg /= nums.size();
		
		System.out.println(avg);
	}
}
