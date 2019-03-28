
package application;

public abstract class Animal {
	
	Integer emotion=10;
	String type;
	public Integer getEmotion() {
		return emotion;
	}
	public void setEmotion(Integer emotion) {
		this.emotion = emotion;
	}
	public String getType() {
		return type;
	}
	public Animal(String type) {
		super();
		this.type = type;
	}
	
	

}
