
package PracticeSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import PracticeSim.Assets.Assets;
import PracticeSim.background.GameObject;
import PracticeSim.background.ID;


public class Animal extends GameObject implements AnimalActions{
	
	private int emotion=10;
	private int size =20;
	protected String type;
	protected String name;
	protected String breed;
	private String action;
	//IDs are for counts
	protected final int dogID =0;
	protected final int catID =1;
	protected final int birdID =2;
	protected int ID=4;
	
	private BufferedImage image;

	
	//there needs work to make sure the pets gets added to the background objects
	public Animal(String type,String breed,String name,ID id,int x, int y) {
		super(x,y,id);
		this.type = type;
		this.name= name;
		this.breed = breed;
		if(type == "Dog") {
			ID = dogID;
			image = Assets.dog;
		}
		else if(type == "Cat") {
			ID = catID;
			image = Assets.cat;
		}
		else if(type == "Bird") {
			ID = birdID;
			image = Assets.bird;
		}
		velX = 15;
		velY = 15;
	}
	public Integer getEmotion() {
		return emotion;
	}
	public void setEmotion(Integer emotion) {
		this.emotion = emotion;
	}
	public String getType() {
		return type;
	}
	public BufferedImage getAsset() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String act) {
		this.action = act;
	}

	@Override
	public void Fly() {
		
		if(getType() == "Dog" || getType() == "Cat"){
			action= getName()+" looks at you Funny!";
		}
		else if(getType() == "Bird") {
			action = getName()+" took off and is flying around";
		}
		setAction(action);
	}
	
	@Override
	public void Catch() {
		if(getType() == "Dog"){
			action= getName()+" trys to catch a squirrel.";
		}
		else if(getType() == "Bird") {
			action = getName()+" trys to catch something";
		}
		else if(getType() == "Cat") {
			action = getName() + "trys to catch a bird.";
					
		}
		setAction(action);
	}
	@Override
	public void Speak() {
		if(getType() == "Dog"){
			action= getName()+" BARKS!!";
		}
		else if(getType() == "Bird") {
			action = getName()+" makes a noise";
		}
		else if(getType() == "Cat") {
			action = getName() + "MEOW!!";
					
		}
		setAction(action);
	}
	@Override
	public void Chase() {
		if(getType() == "Bird" || getType() == "Cat"){
			action= getName()+" ignores you!";
		}
		else if(getType() == "Dog") {
			action = getName()+" catches a squirrel!";
		}
		setAction(action);
	}
	@Override
	public void Flee() {
		if(emotion >3){
			action= getName()+" does nothing.";
		}
		else {
			action = getName()+" runs aways and slowly comes back with head down.";
		}
		setAction(action);
	}
	@Override
	public void Bite() {
		if(emotion >3){
			action= getName()+" does nothing.";
		}
		else {
			action = getName()+" bites owner";
		}
		setAction(action);
	}
	@Override
	public void Play() {
		action= getName() + "is playing.";
		setAction(action);
	}
	@Override
	public void Fetch() {
		if(getType() == "Dog" || getType() == "Cat"){
			action= getName()+" looks at the directions and runs away from you.\nComes back with nothing";
		}
		else if(getType() == "Bird") {
			action = getName()+" flys away and circles.\nReturns to you.";
		}
		setAction(action);
	}
	@Override
	public void Lick() {
		if(getType() == "Dog" || getType() == "Cat"){
			action= getName()+" is trying to lick your face!";
		}
		else if(getType() == "Bird") {
			action = getName()+" tongue isnt long enough.";
		}
		setAction(action);
	}
	@Override
	public void Rest() {
		action = getName()+" is resting";
		setAction(action);
	}
	
	// for background boxes
	public Rectangle getBounds() {
		return new Rectangle(x, y, size, size);
	}

	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 38)
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 300)
			velX *= -1;
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, size, size);
	}

}