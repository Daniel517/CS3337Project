package PracticeSim.Menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
	

	public CreationMenu(Game game, Handler handler ) {
		this.game = game;
		this.handler = handler;
		r = new Random();
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
				handler.addObject(new WildAnimal(r.nextInt(game.WIDTH-300), 300, ID.WildAnimal,handler));
				handler.addObject(new WildAnimal(r.nextInt(game.WIDTH-300), 300, ID.WildAnimal,handler));
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
		g.drawRect(720, 750, 180, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Add Pet", 725, 800);
		
		g.setColor(Color.white);
		g.drawRect(960, 750, 215, 75);
		
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Enter Sim", 975, 800);
	}
	
	public void getName() {
		String inStr = JOptionPane.showInputDialog(null, "What name do you want to use?",
	            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
	      name = inStr;
	}
	public void getPet() {
		String[] type = {"Select One","Dog", "Cat", "Bird"};
		String[] breedD = {"Select One","Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese"};
		String[] breedC = {"Select One","Siamese", "Tabicat", "Persian", "Sphinx"};
		String[] breedB = {"Select One","Pigeon", "Hawk", "Parrot", "Parakeet"};
		
		
		String PetType = (String) JOptionPane.showInputDialog(null, "Select Type ","Pet Creation", JOptionPane.QUESTION_MESSAGE, null, type, "Select One");
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
		
	}
	
	/*String Ptype = JOptionPane.showInputDialog(null, "What name do you want to use?",
	            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
	 * ChoiceBox<String> pet1Type = new ChoiceBox<String>();
		pet1Type.getItems().addAll("Select Pet", "Dog", "Cat", "Bird");
		pet1Type.setValue(pet1TypeIn);
		ChoiceBox<String> pet1Breed = new ChoiceBox<String>();
		setUpSecondChoiceBox(pet1Breed, pet1Type.getValue(), pet1BreedIn);
		pet1Type.setOnAction(e -> setUpSecondChoiceBox(pet1Breed, pet1Type.getValue()));
		
		private void setUpSecondChoiceBox(ChoiceBox<String> petBreed, String petType) {
		petBreed.getItems().clear();
		switch (petType) {
		case "Dog":
			petBreed.getItems().addAll("Select Breed", "Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese");
			petBreed.setValue("Select Breed");
			break;
		case "Cat":
			petBreed.getItems().addAll("Select Breed", "Siamese", "Tabicat", "Persian", "Sphinx");
			petBreed.setValue("Select Breed");
			break;
		case "Bird":
			petBreed.getItems().addAll("Select Breed", "Pigeon", "Hawk", "Parrot", "Parakeet");
			petBreed.setValue("Select Breed");
		}
	}
		
	 */

}
