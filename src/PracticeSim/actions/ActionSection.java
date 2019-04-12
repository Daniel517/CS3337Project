package PracticeSim.actions;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import PracticeSim.Game;
import PracticeSim.Game.STATE;
import PracticeSim.background.Handler;

@SuppressWarnings("serial")
public class ActionSection extends JPanel{
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
	String[] actions = {"Fly","Catch","Speak","Chase","Flee","Bite","Play","Fetch","Lick","Rest","Leave Park","Exist Simulator"};
	private Game game;
	private JPanel actionPanel;
	private boolean action;
	private boolean added= false;
	
	//Add a Jpanel to the window
	public ActionSection(Game game) {
		this.game = game;
		action = false;
		actionPanel = game.window.getPanel();
		
//		if(game.gameState == STATE.GameHome) {
//			
//		}
	}
	
	public void tick() {
		
		if(game.gameState == STATE.GameHome) {
			JButton b1 = new JButton("Stay Home");
			b1.setBounds(980, 700, 150, 50);
			b1.setBackground(Color.ORANGE);
			//b1.addActionListener(this);
			JButton b2 = new JButton("Go to Park");
			b2.setBounds(980, 610, 150, 50);
			b2.setBackground(Color.ORANGE);
			//b2.addActionListener(this);
			JButton b3 = new JButton("Exit Simulator");
			b3.setBounds(980, 790, 150, 50);
			b3.setBackground(Color.ORANGE);
			//b3.addActionListener(this);
			actionPanel.add(b1);
			actionPanel.add(b2);
			actionPanel.add(b3);
			actionPanel.setVisible(true);
			if(added) {
				game.window.actionPanel.add(actionPanel);
				added = true;
			}
		}
		else if(game.gameState == STATE.GamePark) {
			
		}
		else if(game.gameState == STATE.GamePark && action == true) {
			action= false;
		}
		
	}
	
	@SuppressWarnings("unused")
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
			System.out.println("Stay Home was pressed");
	}
	
	public void render(Graphics g) {
		
	}
	 
	
}
