package PracticeSim.background;

import java.util.Random;

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
		if(time.getHour() % 2 == 1 && time.getTenth() == 0 && time.getMin() ==0) {
			if(!added) {
				handler.addObject(new WildAnimal(r.nextInt(900), 300, ID.WildAnimal,handler));
				added = true;
			}
		}
		if(time.getHour() % 2 == 1 && time.getTenth() == 0 && time.getMin() == 1) {
			added = false;
		}
	}

}
