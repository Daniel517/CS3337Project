package application.states;

import java.awt.Graphics;

import application.Handler;
import application.gfx.Assets;

public class GameState extends State{

	public GameState(Handler handler) {
		super(handler);
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.home, 10, 10, null);
	}

}
