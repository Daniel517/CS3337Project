package PracticeSim;

import java.util.ArrayList;

public class humanOwner {
	
	public String humanName;
	public ArrayList<Animal> pets;
	public Animal activePet;
	private int report = 2;
	
	public humanOwner(String name,ArrayList<Animal> pets) {
		this.humanName = name;
		this.pets = pets;
		
	}
	public void addPet(Animal e) {
		pets.add(e);
	}
	public String getHumanname() {
		return humanName;
	}
	public void changeActivePet() {
		
	}
	public void setActivePet() {
		
	}
	
	public void reportMade() {
		report =- 1;
	}

}
