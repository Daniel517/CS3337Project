package PracticeSim.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import PracticeSim.Animal;
import PracticeSim.Game;
import PracticeSim.WildAnimal;
import PracticeSim.Game.STATE;
import PracticeSim.background.Handler;
import PracticeSim.background.ID;
import javafx.scene.control.ChoiceBox;

public class CreationMenu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	//private JTextArea textarea;
	//private JTextField input = new JTextField("name",15);
	private String name="";
	private String Petname="";
	private String PetType="";
	private String PetBreed="";
	private Random r;
	private ArrayList<Animal> pets; 
	
	private int count = 0;
	

	public CreationMenu(Game game, Handler handler ) {
		this.game = game;
		this.handler = handler;
		r = new Random();
		pets = new ArrayList<Animal>();
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Creation) {
			//play button
			if(mouseOver(mx,my,440, 300, 400, 175)) {
				getName();
				//game.gameState = STATE.Game;
			}
			
			//Start simulator
			if(mouseOver(mx,my,960, 750, 215, 75)) {
				game.gameState = STATE.Game;
				game.window.sbar.setVisible(true);
				handler.addObject(new WildAnimal(r.nextInt(900), r.nextInt(900), ID.WildAnimal,handler));
				handler.addObject(new WildAnimal(r.nextInt(900),r.nextInt(900), ID.WildAnimal,handler));
				//game.window.addTextArea();
			}
			
			//Add pet
			if(mouseOver(mx,my,720, 750, 180, 75)) {
				getPet();
			}
			
			//quit button
			if(mouseOver(mx,my,25, 750, 100, 75)) {
				System.exit(1);
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("Times New Roman",1, 140);
		Font fnt2 = new Font("Times New Roman",1, 45);
		
		g.setFont(fnt);
		g.setColor(Color.RED);
		g.drawString("Creating Self", 220, 130);
		
		g.setColor(Color.white);
		g.drawRect(230, 230, 270, 80);
		
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Using Name: ", 235,285);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString(name, 515,285);
		
		g.setColor(Color.white);
		g.drawRect(25, 750, 100, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Quit", 30, 800);
		
		g.setColor(Color.white);
		g.drawRect(960, 750, 215, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Enter Sim", 975, 800);
		if(count == 0) {
			g.setColor(Color.white);
			g.drawRect(720, 750, 180, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Add Pet", 725, 800);
			
		}
		else if(count == 1) {
			g.setColor(Color.white);
			g.drawRect(720, 750, 180, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Add Pet", 725, 800);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() +": "+pets.get(0).getName(), 235,385);
		}
		else if(count == 2) {
			g.setColor(Color.white);
			g.drawRect(720, 750, 180, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Add Pet", 725, 800);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() +": "+pets.get(0).getName(), 235,385);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(1).getType() +" - "+ pets.get(1).getBreed() +": "+pets.get(1).getName(), 235,485);
			
		}
		else if(count == 3) {
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() +": "+pets.get(0).getName(), 235,385);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(1).getType() +" - "+ pets.get(1).getBreed() +": "+pets.get(1).getName(), 235,485);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(2).getType() +" - "+ pets.get(2).getBreed() +": "+pets.get(2).getName(), 235,585);
		}
	}
	
	public void getName() {
		String inStr = JOptionPane.showInputDialog(null, "What name do you want to use?",
	            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
	      name = inStr;
	}
	public void makePet(String type, String breed, String name) {
		pets.add(new Animal(type,breed,name));
		PetType ="";
		PetBreed="";
		Petname="";
	}
	public void getPet() {
		String[] type = {"Select One","Dog", "Cat", "Bird"};
		String[] breedD = {"Select One","Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese"};
		String[] breedC = {"Select One","Siamese", "Tabicat", "Persian", "Sphinx"};
		String[] breedB = {"Select One","Pigeon", "Hawk", "Parrot", "Parakeet"};
		
		
		PetType = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, type, "Select One");
		if(PetType == "Dog") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedD, "Select One");
			Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		}
		else if(PetType == "Cat") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedC, "Select One");
			Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		}
		else if(PetType == "Bird") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedB, "Select One");
			Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		}
		count +=1;
		makePet(PetType,PetBreed,Petname);
	}
	

}
