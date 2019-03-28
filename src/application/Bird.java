package application;

public class Bird extends Animal implements AnimalActions {
	String name;
	String breed;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Bird(String type, String name, String breed) {
		super(type);
		this.name = name;
		this.breed = breed;
	}
	@Override
	public String Fly() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Catch() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Speak() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Chase() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Flee() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Bite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Play() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Fetch() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Lick() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Rest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
