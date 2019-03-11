package application;

public class Animal {
	
	String name;
	Integer emotion;
	String type;
	
	public Animal(String name, Integer emotion, String type) {
		super();
		this.name = name;
		this.emotion = emotion;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	

}
