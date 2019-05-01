package PracticeSim.background;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import PracticeSim.Animal;
import PracticeSim.WildAnimal;
import PracticeSim.humanOwner;
import PracticeSim.AnimalList.AnimalList;
import PracticeSim.Assets.Assets;

public class Spawn {
	
	private Handler handler;
	private AnimalList animalList;
	private Time time;
	private Random r= new Random();
	private boolean added= false;
	private ArrayList<Animal> RandomPets= new ArrayList<Animal>();
	private String[] type = {"Dog", "Cat", "Bird"};
	private String[] breeds = {"Pitbull","Hawk","Siamese","Poodle","Pigeon","Tabicat","Maltese","Parrot","Persian","Sphinx","Rat Terrier","Parakeet","Husky"};
	private String[] PetNames = {"Max","Fluffy","Dragon","Pat","Million","Billion","Boss","King","Queen","Prince","Royal","Being","Love","Drake","Sam","Bella","Grace","Luke","Vader","Star"};
	private String[] HumanName = {"Olivia","Oliver","Amelia","Harry","Isla","Jack","Emily","George","Ava","Noah","Lily","Charlie","Mia","Jacob","Sophia","Alfie","Isabella","Freddie","Grace","Oscar"};
	
	public Spawn(Handler handler,AnimalList animalList,Time time) {
		this.handler = handler;
		this.animalList = animalList;
		this.time = time;
	}
	public void tick() {
		if(time.getHour() % 2 == 1 && time.getMinutes() == 59) {
			if(!added) {
				Animal an = new Animal(ID.WildAnimal,r.nextInt(900),r.nextInt(900));
				Animal an2 = new Animal(ID.WildAnimal,r.nextInt(900),r.nextInt(900));
				handler.addObject(an);
				handler.addObject(an2);
				added = true;
			}
		}
		if(time.getHour() % 2 == 0 && time.getMinutes() == 0 && time.getSeconds() == 1) {
			added = false;
		}
	}
	public ArrayList<Animal> getRandomPets() {
		return RandomPets;
	}
	public String getType(int e) {
		return type[e];
	}
	public String getBreeds(int e) {
		return breeds[e];
	}
	
	public humanOwner getComHuman() {
		humanOwner computer=null;
		int breedInt = r.nextInt(breeds.length);
		int x=r.nextInt(900);
		int y=r.nextInt(900);
		RandomPets.add(new Animal(getType(r.nextInt(type.length)),getBreeds(breedInt),getPetNames(r.nextInt(PetNames.length)),ID.Pet,x,y,getImage(getBreeds(breedInt))));
		
		return computer;
	}
	public BufferedImage getImage(String e) {
		BufferedImage pic=null;
		if(e=="Pitbull") {
			pic = Assets.Pitbull;
		}
		else if(e == "Rat Terrier") {
			pic = Assets.RatTerrier;
		}
		else if(e == "Poodle") {
			pic = Assets.Poodle;
		}
		else if(e == "Parakeet") {
			pic = Assets.Parakeet;
		}
		else if(e == "Parrot") {
			pic = Assets.Parrot;
		}
		else if(e == "Hawk") {
			pic = Assets.Hawk;
		}
		else if(e == "Pigeon") {
			pic = Assets.Pigeon;
		}
		else if(e == "Sphinx") {
			pic = Assets.Sphinx;
		}
		else if(e == "Persian") {
			pic = Assets.Persian;
		}
		else if(e == "Tabicat") {
			pic = Assets.Tabicat;
		}
		else if(e == "Siamese") {
			pic = Assets.Siamese;
		}
		else if(e == "Maltese") {
			pic = Assets.Maltese;
		}
		else if(e == "Husky") {
			pic = Assets.Husky;
		}
		return pic;
	}
	public String getPetNames(int e) {
		return PetNames[e];
	}
	public String getHumanName(int e) {
		return HumanName[e];
	}
	
	
}
