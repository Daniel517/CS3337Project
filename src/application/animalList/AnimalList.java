package application.animalList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import application.Animal;
import application.Bird;
import application.Cat;
import application.Dog;
import application.Handler;
import application.gfx.Assets;

public class AnimalList {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Animal> animalsInPark;

	private int countDog;
	private int countCat;
	private int countBird;
	private int countWild;
	private Font font= new Font("Times New Roman", 10, 25);
	private Color c = Color.white;
	
	private int alcx = 1000 + 70,
			alcy = 0 + 70,
			spacing = 25;
	private int AImageX = 1200,
			AImageY = 50, AImageWidth = 64,
					AImageHeight = 64;
	private int ACountX = 1232, ACountY = 140;
	
	private int selectedAnimal = 0;
	
	
	public AnimalList(Handler handler) {
		this.handler = handler;
		animalsInPark = new ArrayList<Animal>();
		this.countDog = 0;
		this.countBird = 0;
		this.countCat = 0;
		this.countWild =0;
		
		animalsInPark.add(new Dog("Dog", "Hook", "Pit Bull"));
		animalsInPark.add(new Cat("Cat", "Fuffly", "Spix"));
		animalsInPark.add(new Bird("Bird", "Tony", "Hank"));
	}
	public void tick() {
		System.out.println("Working aninmal list");
		//count();
	}
	public void render(Graphics g) {
		g.drawImage(Assets.list, 1000,0, null);
		
		Text.drawString(g, "Animals", alcx, 25, true, c, font);
		
		int len = animalsInPark.size();
		if(len == 0)
			return;
		
		for(int i = 0; i< 20; i++)
		{
			if(selectedAnimal + i <0 || selectedAnimal +i >= len)
				continue;
			Text.drawString(g, animalsInPark.get(selectedAnimal +i).getType(), alcx, alcy + i * spacing, true, c, font);
		}
	}
	
	public void count() {
		for(Animal i : animalsInPark)
		{
			if(i.getType() == "Dog") {
				countDog++;
			}
			else if(i.getType() == "Cat") {
				countCat++;
			}
			else if(i.getType() == "Bird") {
				countBird++;
			}
		}
	}
	
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
