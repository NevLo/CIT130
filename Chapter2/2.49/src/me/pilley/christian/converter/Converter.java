package me.pilley.christian.converter;
import java.util.*;
//name: Christian Pilley
//desc: Converts inches to milimeters
//date: 9/14/2018 :: 20:06
public class Converter {
	public static void main(String[] args) {
		ArrayList<Double> inches = new ArrayList<Double>();
		ArrayList<Double> mili = new ArrayList<Double>();
		inches.add(2.0);
		inches.add(5.0);
		inches.add(10.0);
		System.out.println(inches);
		
		for(int i = 0; i < inches.size(); i++){
			mili.add(  convert(  inches.get(i)  )  );
		}
		System.out.println(mili);
	}
	public static double convert(double f) {
		return f * 25.4;
	}
}
