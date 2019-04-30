package PracticeSim.background;

import java.util.Random;

import PracticeSim.Animal;
import PracticeSim.WildAnimal;
import PracticeSim.AnimalList.AnimalList;

public class Spawn {
	
	private Handler handler;
	private AnimalList animalList;
	private Time time;
	private Random r= new Random();
	private boolean added= false;
	
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

}
