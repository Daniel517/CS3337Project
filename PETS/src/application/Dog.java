package application;

public class Dog extends Animal implements AnimalActions{
	
	String breed;
	
	public Dog(String name, Integer emotion, String type,String breed) {
		super(name, emotion, type);
		this.breed=breed;
	}
	public String getBreed() {
		return breed;
	}

	@Override
	public String toString() {
		return "there is a " + breed + " called " + name ;
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
		String action=name+"";
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
