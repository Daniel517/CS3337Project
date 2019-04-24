package PracticeSim;

import java.util.ArrayList;

public class humanOwner {
	
	private String humanName;
	private ArrayList<Animal> pets;
	private Animal activePet;
	private int report = 2;
	
	public humanOwner(String name,ArrayList<Animal> pets) {
		this.humanName = name;
		this.pets = pets;
		
	}
	
	public String getHumanname() {
		return humanName;
	}
	public void changeActivePet() {
		
	}
	
	public void reportMade() {
		report =- 1;
	}

}
