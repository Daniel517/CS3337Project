package PracticeSim.AnimalList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import PracticeSim.WildAnimal;
import PracticeSim.Animal;
import PracticeSim.AnimalList.Text;
import PracticeSim.background.Handler;
import PracticeSim.background.ID;
import PracticeSim.Assets.Assets;;


public class AnimalList {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Animal> animalsInPark;

	//private int countDog=0;
	//private int countCat=0;
	//private int countBird=0;
	//private int countWild=0;
	private Font font= new Font("Times New Roman", 10, 25);
	private Color c = Color.white;
	private Color c2 = Color.red;
	
	private int alcx = 900 + 70,
			alcy = 210 + 70,
			spacing = 25;
	private int AImageX = 1100,
			AImageY = 50, AImageWidth =  AImageX,
					AImageHeight = 17;
	private int ACountX = 1132, ACountY = 90;
	
	private int selectedAnimal = 0;

	public AnimalList(Handler handler) {
		this.handler = handler;
		animalsInPark = new ArrayList<Animal>();

	}
	
	public void tick() {

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			System.out.println("W was pressed " + selectedAnimal);
			selectedAnimal--;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			System.out.println("S was pressed " + selectedAnimal);
			selectedAnimal++;
			
		}

		if (selectedAnimal < 0) {
			selectedAnimal = animalsInPark.size() - 1;
		} else if (selectedAnimal >= animalsInPark.size()) {
			selectedAnimal = 0;
		}
	
	}
	public void render(Graphics g) {
		g.drawImage(Assets.list, 895,0,300,600, null);
		
		Text.drawString(g, "Animals", alcx, 25, true, c, font);
		
		int len = animalsInPark.size();
		if(len == 0)
			return;
		
		for(int i = 0; i< 20; i++)
		{
			if(selectedAnimal + i <0 || selectedAnimal +i >= len) {
				continue;
			}
			if(i == selectedAnimal) {
				Text.drawString(g,"->" + animalsInPark.get(selectedAnimal + i).getType(), alcx, alcy + i * spacing, true, c2, font);
			}else {
				Text.drawString(g, animalsInPark.get(selectedAnimal + i).getType(), alcx, alcy + i * spacing, true, c, font);

			}
		}
		
		
		Animal animal = animalsInPark.get(selectedAnimal);
		g.drawImage(animal.getAsset(), AImageWidth, AImageHeight, null);
		Text.drawString(g, Integer.toString(animalsInPark.size()), ACountX, ACountY, true, c, font);
	}
	public void addAnimal(String type, String breed, String name, ID id) {
		animalsInPark.add(new Animal(type, breed, name, id,0,0));
	}
	public Animal getAnimal(int index) {
		return animalsInPark.get(index);
	}

	public void addToList(Animal a) {
		animalsInPark.add(a);
	}
	public void GoingHomeFromPark() {
		
		for(int i =0;i<animalsInPark.size();i++) {
			if(!animalsInPark.get(i).isIsUserPet()) {
				handler.removeObject(animalsInPark.get(i));
				animalsInPark.remove(animalsInPark.get(i));
				i--;
			}
		}
		
	}

}
