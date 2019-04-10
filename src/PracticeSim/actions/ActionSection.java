package PracticeSim.actions;

import java.awt.Graphics;

import PracticeSim.Assets.Assets;

public class ActionSection {
	/*
	 * this will be where the actions will be chosen. if the game is in the game.home state than the home 
	 * will be shown. the animal list will be changed to take out all the inactive pets.
	 * the inactive pets are those not being used by the player.
	 * 
	 * the user will have one of the actions possible be to go to the park quit or stay at home. if the action stay is used than the 
	 * animal or animals will have 1 subtracted from there emotion level.
	 * 
	 * if the user chose to go to the park than the background will change and the animals will be populated.
	 * 
	 * the actions will be for now all possible actions for an animal. after a delay they will be a response by the user.
	 * these responses will not change. 
	 */
	String[] actions = {"Fly","Catch","Speak","Chase","Flee","Bite","Play","Fetch","Lick","Rest","Quit"};
	
	
	
	public ActionSection() {
		
	}
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.action, 900,600,300,300, null);
	}
	 
	
}
