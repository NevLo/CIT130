package me.pilley.christian.Objects;

public class Patient {
	//Instance Variables
	private int room;
	private int bed;
	private String nurse;
	private String doctor;
	
	//public getters
	public int getRoom() {return room;}
	public int getBed() {return bed;}
	public String getNurse() {return nurse;}
	public String getDoctor() {return doctor;}
	
	//public setters
	public void setRoom(int room) {this.room = room;}
	public void setBed(int bed) {this.bed = bed;}
	public void setNurse(String nurse) {this.nurse = nurse;}
	public void setDoctor(String doctor) {this.doctor = doctor;}
	//Default constructor
	public Patient() { }
	//Overloaded constructor
	public Patient(int room, int bed, String nurse, String doctor) {
		this.room = room;
		this.bed = bed;
		this.nurse = nurse;
		this.doctor = doctor;
	}
	//Display method
	public void displayPatient() {
		//I used a Ternary Operation to determine spacing.
		System.out.println(room + "-" + bed + "\t|" + doctor + 
				(doctor.length() > 6 ? "" : "\t" ) +"\t|" + nurse);
		
		
	}

}

