package application;

public class Pet extends Animal implements AnimalActions{

	String Name;

	public Pet(Integer emotion, String type, String breed, String name) {
		super(emotion, type, breed);
		Name = name;
	}

	@Override
	public String Fly() {
		String action="Dog looks at you Funny!";
		return action;
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
		String action=Name+"";
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
