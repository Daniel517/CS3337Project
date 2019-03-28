package application.states;

import java.awt.Graphics;

import application.Simulator;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	
	//class
	protected Simulator game;
	
	public State(Simulator game) {
		this.game = game;
	}
	
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
