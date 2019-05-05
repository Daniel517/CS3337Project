
package PracticeSim.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import PracticeSim.Animal;
import PracticeSim.Game;
import PracticeSim.Game.STATE;
import PracticeSim.humanOwner;
import PracticeSim.AnimalList.AnimalList;
import PracticeSim.Assets.Assets;
import PracticeSim.background.Handler;
import PracticeSim.background.ID;

public class CreationMenu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private String name="";
	private String Petname="";
	private String PetType="";
	private String PetBreed="";
	private Random r;
	private AnimalList aList;
	private ArrayList<Animal> pets; 
	
	private int count = 0;
	private int spacerforpets = 5;

	public CreationMenu(Game game, Handler handler, AnimalList aList) {
		this.game = game;
		this.handler = handler;
		this.aList = aList;
		r = new Random();
		pets = new ArrayList<Animal>();
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Creation) {
			//play button
			if(mouseOver(mx,my,230, 230, 270, 80)) {
				getName();
				//game.gameState = STATE.Game;
			}
			if(pets.size()>=1) {
				// Start simulator
				if (mouseOver(mx, my, 960, 750, 215, 75)) {
					game.user = new humanOwner(name, pets);
					game.gameState = STATE.GameHome;
					game.window.sbar.setVisible(true);
					game.window.area.append(game.user.getHumanName() + " has woken up!\n");
					game.action.tick();
					addToHandler();

				}
			}
			
			
			//Add pet
			if(mouseOver(mx,my,720, 750, 180, 75)) {
				getPet();
			}
			
			//quit button
			if(mouseOver(mx,my,25, 750, 100, 75)) {
				System.exit(1);
			}
			//Random maker
			if(mouseOver(mx,my,135, 750, 200, 75)) {
				doRandom();
			}
		}
		
	}
	
	
	public void addToHandler() {
		for(int i=0;i<game.user.pets.size();i++) {
			handler.addObject(game.user.pets.get(i));
			
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
	public void doRandom() {
		humanOwner temp = game.doingRandom();
		name = temp.getHumanName();
		for(int i=0;i<temp.pets.size();i++) {
			pets.add(temp.pets.get(i));
			count++;
		}
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
		g.drawString("Enter Name", 235,285);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString(name, 515,285);
		
		g.setColor(Color.white);
		g.drawRect(25, 750, 100, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Quit", 30, 800);
		
		g.setColor(Color.white);
		g.drawRect(135, 750, 200, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Random", 150, 800);
		
		
		if(pets.size()>=1) {
			g.setColor(Color.white);
			g.drawRect(960, 750, 215, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Enter Sim", 975, 800);
		}
		
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
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() + ": " + pets.get(0).getName(), 235,385);
		}
		else if(count == 2) {
			g.setColor(Color.white);
			g.drawRect(720, 750, 180, 75);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Add Pet", 725, 800);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() + ": " + pets.get(0).getName(), 235,385);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(1).getType() +" - "+ pets.get(1).getBreed() + ": " + pets.get(1).getName(), 235,485);
			
		}
		else if(count == 3) {
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(0).getType() +" - "+ pets.get(0).getBreed() + ": " + pets.get(0).getName(), 235,385);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(1).getType() +" - "+ pets.get(1).getBreed() + ": " + pets.get(1).getName(), 235,485);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString(pets.get(2).getType() +" - "+ pets.get(2).getBreed() + ": " + pets.get(2).getName(), 235,585);
		}
	}
	
	public void getName() {
<<<<<<< HEAD
		String inStr="";
		do {
			 inStr = JOptionPane.showInputDialog("What name to use?", "Nobody!");
		} while(inStr == null);
		name = inStr;
=======
		do {
			name = JOptionPane.showInputDialog("Enter the name you would like to use?");
		} while(name.equals(""));
>>>>>>> DanielRamirez
	}
	public void makePet(String type, String breed, String name) {
		//making sure the user has the pet saved as well.
		BufferedImage picture = null;
		picture= getImage(breed);
		pets.add(new Animal(type,breed,name,ID.UserPet,r.nextInt(600),r.nextInt(900),picture));
		PetType ="";
		PetBreed="";
		Petname="";
		spacerforpets *= 5;
	}
	public BufferedImage getImage(String e) {
		BufferedImage pic=null;
		if(e=="Pitbull") {
			pic = Assets.Pitbull;
		}
		else if(e == "Rat Terrier") {
			pic = Assets.RatTerrier;
		}
		else if(e == "Poodle") {
			pic = Assets.Poodle;
		}
		else if(e == "Parakeet") {
			pic = Assets.Parakeet;
		}
		else if(e == "Parrot") {
			pic = Assets.Parrot;
		}
		else if(e == "Hawk") {
			pic = Assets.Hawk;
		}
		else if(e == "Pigeon") {
			pic = Assets.Pigeon;
		}
		else if(e == "Sphinx") {
			pic = Assets.Sphinx;
		}
		else if(e == "Persian") {
			pic = Assets.Persian;
		}
		else if(e == "Tabicat") {
			pic = Assets.Tabicat;
		}
		else if(e == "Siamese") {
			pic = Assets.Siamese;
		}
		else if(e == "Maltese") {
			pic = Assets.Maltese;
		}
		else if(e == "Husky") {
			pic = Assets.Husky;
		}
		return pic;
	}
	
	public void getPet() {
		String[] type = {"Dog", "Cat", "Bird"};
		String[] breedD = {"Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese"};
		String[] breedC = {"Siamese", "Tabicat", "Persian", "Sphinx"};
		String[] breedB = {"Pigeon", "Hawk", "Parrot", "Parakeet"};
<<<<<<< HEAD
		String[] options = {"OK"};
		int selection = -1;
		
		do {
			PetType = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.CLOSED_OPTION, null, type, "Dog");
		} while(PetType == null);
		
		if(PetType == "Dog") {
			do {
				selection = JOptionPane.showOptionDialog(null,new JPanel() , "Pet Breed", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, breedD , options[0]);
			} while(selection == -1);
			PetBreed = breedD[selection];
			Petname = getPETName();
		}
		else if(PetType == "Cat") {
			do {
				selection = JOptionPane.showOptionDialog(null,new JPanel() , "Pet Breed", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, breedC , options[0]);
			} while(selection == -1);
			PetBreed = breedC[selection];
			Petname = getPETName();		
		}
		else if(PetType == "Bird") {
			do {
				selection = JOptionPane.showOptionDialog(null,new JPanel() , "Pet Breed", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, breedB , options[0]);
			} while(selection == -1);
			PetBreed = breedB[selection];
			Petname = getPETName();		
=======
		
		PetType = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, type, "Dog");
		
		if(PetType == "Dog") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedD, "Pitbull");
			getPetName();
			//Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		}
		else if(PetType == "Cat") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedC, "Siamese");
			//Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
			getPetName();
		}
		else if(PetType == "Bird") {
			PetBreed = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, breedB, "Pigeon");
			//Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
			getPetName();
>>>>>>> DanielRamirez
		}
		count +=1;
		makePet(PetType,PetBreed,Petname);
	}
<<<<<<< HEAD
	public String getPETName() {
		String nametemp = "";
		
		do {
			nametemp = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.CLOSED_OPTION);
		} while(nametemp == null);
		
		return nametemp;
=======
	public void getPetName() {
		do {
			Petname = JOptionPane.showInputDialog(null, "What name do you want to use?", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		} while(Petname.equals(""));
>>>>>>> DanielRamirez
	}
	

}
