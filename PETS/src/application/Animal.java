package application;

public class Animal {
	
	Integer emotion;
	String type;
	String breed;
	
	public Animal(Integer emotion, String type, String breed) {
		super();
		this.emotion = emotion;
		this.type = type;
		this.breed = breed;
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
	public void setType(String type) {
		this.type = type;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

}
