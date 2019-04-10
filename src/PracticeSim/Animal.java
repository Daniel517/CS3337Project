
package PracticeSim;

import java.awt.image.BufferedImage;

import PracticeSim.Assets.Assets;


public class Animal implements AnimalActions{
	
	Integer emotion=10;
	protected String type;
	protected String name;
	protected String breed;
	private String action;
	
	protected final int dogID =0;
	protected final int catID =1;
	protected final int birdID =2;
	protected int ID=4;
	
	private BufferedImage image;
	
	public Animal(String type,String breed,String name) {
		super();
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
			action= getType()+" looks at you Funny!";
		}
		else if(getType() == "Bird") {
			action = getName()+" took off and is flying around";
		}
		setAction(action);
	}
	@Override
	public String Catch( ) {
		String action="Dog get a hold of ";
		return action;
	}
	@Override
	public String Speak() {
		String action="Braks!!";
		return action;
	}
	@Override
	public String Chase() {
		String action="";
		return action;
	}
	@Override
	public String Flee() {
		String action="";
		return action;
	}
	@Override
	public String Bite() {
		String action="";
		return action;
	}
	@Override
	public String Play() {
		String action="";
		return action;
	}
	@Override
	public String Fetch() {
		String action="";
		return action;
	}
	@Override
	public String Lick() {
		String action="";
		return action;
	}
	@Override
	public String Rest() {
		String action="";
		return action;
	}

}