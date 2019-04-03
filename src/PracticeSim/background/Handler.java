package PracticeSim.background;

import java.awt.Graphics;
import java.util.LinkedList;

import PracticeSim.Game;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private Game game;
	public Handler(Game game) {
		this.game = game;
	}
	
	public void tick() {
		for(int i =0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public void render(Graphics g) {
		for(int i =0; i<object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
