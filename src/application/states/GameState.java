package application.states;

import java.awt.Graphics;

import application.Simulator;
import application.gfx.Assets;

public class GameState extends State{

	public GameState(Simulator sim) {
		super(sim);
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.home, 10, 10, null);
	}

}
