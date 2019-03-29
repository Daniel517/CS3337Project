package application.animalList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.event.KeyEvent;
import application.Animal;
import application.Bird;
import application.Cat;
import application.Dog;
import application.background.Handler;
import application.gfx.Assets;

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
	
	private int alcx = 1000 + 70,
			alcy = 0 + 70,
			spacing = 25;
	private int AImageX = 1200,
			AImageY = 50, AImageWidth =  AImageX,
					AImageHeight = 17;
	private int ACountX = 1232, ACountY = 90;
	
	private int selectedAnimal = 0;
	
	
	public AnimalList(Handler handler) {
		this.handler = handler;
		animalsInPark = new ArrayList<Animal>();
		//this.countDog = 0;
		//this.countBird = 0;
		//this.countCat = 0;
		//this.countWild =0;
		
		animalsInPark.add(new Dog("Dog", "Hook", "Pit Bull"));
		animalsInPark.add(new Cat("Cat", "Fuffly", "Spix"));
		animalsInPark.add(new Bird("Bird", "Tony", "Hank"));
	}
	public void tick() {
		try {
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
				selectedAnimal--;
			}
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
				selectedAnimal++;
			}
			
			if(selectedAnimal < 0)
			{
				selectedAnimal = animalsInPark.size()-1;
			}
			else if(selectedAnimal >= animalsInPark.size()) {
				selectedAnimal =0;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//count();
		//System.out.println("pressed something");
	}
	public void render(Graphics g) {
		g.drawImage(Assets.list, 1000,0,300,700, null);
		
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
				Text.drawString(g,"->" + animalsInPark.get(selectedAnimal +i).getType(), alcx, alcy + i * spacing, true, c2, font);
			}else {
				Text.drawString(g, animalsInPark.get(selectedAnimal +i).getType(), alcx, alcy + i * spacing, true, c, font);

			}
		}
		
		Animal animal = animalsInPark.get(selectedAnimal);
		g.drawImage(animal.getAsset(), AImageWidth, AImageHeight, null);
		Text.drawString(g, Integer.toString(animalsInPark.size()), ACountX, ACountY, true, c, font);
	}
	
//	public void count() {
//		for(Animal i : animalsInPark)
//		{
//			if(i.getType() == "Dog") {
//				countDog++;
//			}
//			else if(i.getType() == "Cat") {
//				countCat++;
//			}
//			else if(i.getType() == "Bird") {
//				countBird++;
//			}
//		}
//	}
	
	public void addAnimal(Animal e) {
		animalsInPark.add(e);
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	

}
