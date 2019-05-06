package PracticeSim.background;

import java.awt.Graphics;
import java.util.LinkedList;

import PracticeSim.Animal;
import PracticeSim.Game;
import PracticeSim.Game.STATE;
import PracticeSim.Player;

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
		game.addtoAList((Animal) object);
	}
	public void addPlayer(Player ob) {
		this.object.add(ob);
	}
	public void removePlayer() {
		for(int i =0; i<object.size();i++) {
			if(object.get(i).getId() == ID.player) {
				object.remove(i);
			}
		}
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public STATE getGameState() {
		return game.gameState;
	}
	
	public STATE setGameState() {
		return game.gameState = STATE.GamePark;
	}
	
	public void addTextToArea(String str) {
		game.window.area.append(str+"\n");
	}
}
