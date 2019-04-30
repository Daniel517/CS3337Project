package PracticeSim.actions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton[] buttons= new JButton[12];
	private Game game;
	private JPanel actionPanel;
	private JPanel ParkActionPanel;
	private JPanel ReactionPanel;
	private boolean action;
	private boolean added= false;
	private boolean SecondAdd= false;
	
	//These are for the delay between actions on screen.
	private boolean action1=false;
	private boolean action2=false;
	private boolean action3=false;
	
	
	//Add a Jpanel to the window
	public ActionSection(Game game) {
		this.game = game;
		action = false;
		actionPanel = game.window.getPanel();
		ParkActionPanel = game.window.getParkActionPanel();
		ReactionPanel = game.window.getReactionPanel();
		homeActions();
		parkActions();
		ActionReponse();
		
//		if(game.gameState == STATE.GameHome) {
//			
//		}
	}
	
	public void tick() {
		
		if(game.gameState == STATE.GameHome) {
			game.window.actionPanel.setVisible(true);
			if(added) {
				game.window.actionPanel.add(actionPanel);
				added = true;
			}
		}
		else if(game.gameState == STATE.GamePark) {
			game.window.actionPanel.setVisible(false);
			if(action1) {
				game.window.ParkActionPanel.setVisible(true);
				if(SecondAdd) {
					game.window.ParkActionPanel.add(ParkActionPanel);
					added = true;
				}
			}
			
			if(action2 && !action3) {
				game.window.ParkActionPanel.setVisible(false);
				game.window.ReactionPanel.setVisible(true);
			}
			
			
			
		}

		
	}
	
	
	private void homeActions() {
		JButton b1 = new JButton("Stay Home");
		b1.setBounds(980, 700, 150, 50);
		b1.setBackground(Color.ORANGE);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.getHumanName()+" has choosen to stay home\n");
				game.user.StayHome();
			}
			
		});
		JButton b2 = new JButton("Go to Park");
		b2.setBounds(980, 610, 150, 50);
		b2.setBackground(Color.ORANGE);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.getHumanName()+" has choosen to go to the Park!\n");
				game.user.WentToPark();
				game.gameState = STATE.GamePark;
				action1=true;
				tick();
			}
			
		});
		JButton b3 = new JButton("Exit Simulator");
		b3.setBounds(980, 790, 150, 50);
		b3.setBackground(Color.ORANGE);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
				
			}
			
		});
		actionPanel.add(b1);
		actionPanel.add(b2);
		actionPanel.add(b3);
		actionPanel.setVisible(false);
	}
	
	private void parkActions() {
		int spacer= 610;
		
		JButton b1 = new JButton("Fly");
		b1.setBounds(980, spacer, 150, 50);
		b1.setBackground(Color.ORANGE);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to fly.\n");
				game.user.activePet.Fly();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();
			}
			
		});
		spacer += 90;
		JButton b2 = new JButton("Catch");
		b2.setBounds(980, spacer, 150, 50);
		b2.setBackground(Color.ORANGE);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to catch.\n");
				game.user.activePet.Catch();
				game.window.area.append(game.user.activePet.getAction()+"\n");				
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b3 = new JButton("Speak");
		b3.setBounds(980, spacer, 150, 50);
		b3.setBackground(Color.ORANGE);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to speak.\n");
				game.user.activePet.Speak();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b4 = new JButton("Chase");
		b4.setBounds(980, spacer, 150, 50);
		b4.setBackground(Color.ORANGE);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to chase.\n");
				game.user.activePet.Chase();
				game.window.area.append(game.user.activePet.getAction()+"\n");				
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b5 = new JButton("Flee");
		b5.setBounds(980, spacer, 150, 50);
		b5.setBackground(Color.ORANGE);
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to flee.\n");
				game.user.activePet.Flee();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b7 = new JButton("Bite");
		b7.setBounds(980, spacer, 150, 50);
		b7.setBackground(Color.ORANGE);
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to bite.\n");
				game.user.activePet.Bite();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b8 = new JButton("Play");
		b8.setBounds(980, spacer, 150, 50);
		b8.setBackground(Color.ORANGE);
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to play.\n");
				game.user.activePet.Play();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b9 = new JButton("Fetch");
		b9.setBounds(980, spacer, 150, 50);
		b9.setBackground(Color.ORANGE);
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to fetch.\n");
				game.user.activePet.Fetch();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b10 = new JButton("Lick");
		b10.setBounds(980, spacer, 150, 50);
		b10.setBackground(Color.ORANGE);
		b10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to lick.\n");
				game.user.activePet.Lick();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b11 = new JButton("Rest");
		b11.setBounds(980, spacer, 150, 50);
		b11.setBackground(Color.ORANGE);
		b11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" was told to rest.\n");
				game.user.activePet.Rest();
				game.window.area.append(game.user.activePet.getAction()+"\n");
				action2 = true;
				action3 = false;
				tick();				
			}
			
		});
		spacer += 90;
		JButton b12 = new JButton("Exist Simulator");
		b12.setBounds(980, spacer, 150, 50);
		b12.setBackground(Color.ORANGE);
		b12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
				
			}
			
		});
		spacer += 90;
		JButton b13 = new JButton("Go Home");
		b13.setBounds(980, spacer, 150, 50);
		b13.setBackground(Color.ORANGE);
		b13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append("Going Home\n");
				game.leavingPark();
				game.gameState = STATE.GameHome;
				action1= false;
				added= false;
				game.window.ReactionPanel.setVisible(false);
				game.window.ParkActionPanel.setVisible(false);
				tick();
			}
			
		});
		spacer += 90;
		
		//Bite","Play","Fetch","Lick","Rest","Leave Park","Exist Simulator"
		ParkActionPanel.add(b1);
		ParkActionPanel.add(b2);
		ParkActionPanel.add(b3);
		ParkActionPanel.add(b4);
		ParkActionPanel.add(b5);
		ParkActionPanel.add(b7);
		ParkActionPanel.add(b8);
		ParkActionPanel.add(b9);
		ParkActionPanel.add(b10);
		ParkActionPanel.add(b11);
		ParkActionPanel.add(b12);
		ParkActionPanel.add(b13);
		ParkActionPanel.setVisible(false);
	}
	public void ActionReponse() {
		int spacer=610;
		
		JButton b14 = new JButton("Good job!");
		b14.setBounds(980, spacer, 150, 50);
		b14.setBackground(Color.ORANGE);
		b14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append("Good Job was pressed\n");	
				action2 = false;
				action3 = true;
				game.window.ReactionPanel.setVisible(false);
				tick();
			}
			
		});
		spacer += 90;
		JButton b15 = new JButton("Stay silent");
		b15.setBounds(980, spacer, 150, 50);
		b15.setBackground(Color.ORANGE);
		b15.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append("Hearing circkets\n");
				action2=false;
				action3=true;
				game.window.ReactionPanel.setVisible(false);
				tick();
			}
			
		});
		spacer += 90;
		JButton b16 = new JButton("Hit Animal");
		b16.setBounds(980, spacer, 150, 50);
		b16.setBackground(Color.ORANGE);
		b16.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.window.area.append(game.user.activePet.getName()+" hit "+game.user.activePet.getName()+".\n");
				game.user.HitAnimal();
				game.window.ReactionPanel.setVisible(false);
				tick();
			}
			
		});
		
		ReactionPanel.add(b14);
		ReactionPanel.add(b15);
		ReactionPanel.add(b16);
		ReactionPanel.setVisible(false);
	}
	public void sleep() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		
	}
	 
	
}
