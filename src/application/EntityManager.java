package application;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private Handler handler;
	
	//this will be the user
	private Human human;
	// may have to make another class above human and animal
	private ArrayList<Human> entities;
	
	
	public EntityManager(Handler handler, Human human) {
		this.handler =  handler;
		this.human =  human;
		entities = new ArrayList<Human>();
	}
	
	public void tick() {
		for(int i = 0; i<entities.size();i++) {
			//this will be adding all the animals in the park
		}
		//player.tick();
	}
	
	public void render(Graphics g) {
		
	}
	public void addEntity(Human e) {
		entities.add(e);
	}


	public Handler getHandler() {
		return handler;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}


	public Human getHuman() {
		return human;
	}


	public void setHuman(Human human) {
		this.human = human;
	}


	public ArrayList<Human> getEntities() {
		return entities;
	}


	public void setEntities(ArrayList<Human> entities) {
		this.entities = entities;
	}
	
	

}
