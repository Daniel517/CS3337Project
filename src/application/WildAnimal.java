package application;

public class WildAnimal extends Animal implements AnimalActions{
	String Breed="Squirrel";

	public WildAnimal(String name, Integer emotion, String type, String breed) {
		super(name);
		Breed = breed;
	}
	

	public String getBreed() {
		return Breed;
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
