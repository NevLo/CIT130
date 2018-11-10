package me.pilley.christian.Objects;

import java.util.Random;
//NAME: Christian Pilley
//DATE: 11/14/18 :: 0018
//DESC: Patient Manager project. This client allows for the creation of 
//      patients, that have variables room, bed, nurse, and doctor.
public class ObjectStuff {
	//String array for nursing staff
	static String[] RNs = {"Amee","Kelly","Sara","Jose","Chaz"};
	//String array for doctors
	static String[] MDs = {"Peters","Ritchie","Kazanchyn","Shonnard","Zebrack"};
	//random variable for getting a random doctor and nurse
	static Random rand = new Random();
	//main method
	public static void main(String... args) {
		//Declaration of objects
		Patient jane_doe = new Patient(); 
		Patient jane_green = new Patient(204, 2, "Amee", "Hosp");
		Patient john_deer = getPatientFromER(205, 0);
		
		//Setting object 1's values
		jane_doe.setBed(1);
		jane_doe.setRoom(204);
		jane_doe.setDoctor("Peters");
		jane_doe.setNurse("Kelly");
		//displaying the objects
		displayPatients(jane_doe, jane_green, john_deer);
		
		
	}
	//Display all patients
	//I used a variable argument here to make it easy to send all the patients
	//to this method without the use of arrays.
	public static void displayPatients(Patient...patients) {
		System.out.println("Room\t|Physician\t|Nurse"
				+ "\n-------------------------------");
		for(Patient p : patients) {
			p.displayPatient();
		}
	}
	//Used to return a new (semi) random patient.
	public static Patient getPatientFromER(int floorRoom, int floorBed) {
		return new Patient(floorRoom, 
				floorBed, 
				RNs[rand.nextInt(5)], 
				MDs[rand.nextInt(5)]);
	}
}
