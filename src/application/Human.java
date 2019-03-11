package application;

public class Human {
	String name;
	Integer report;
	Animal pet;
	Animal[] interact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getReport() {
		return report;
	}
	public void setReport(Integer report) {
		this.report = report;
	}
	public Animal getPet() {
		return pet;
	}
	public void setPet(Animal pet) {
		this.pet = pet;
	}
	public Animal[] getInteract() {
		return interact;
	}
	public void setInteract(Animal[] interact) {
		this.interact = interact;
	}
	public Human(String name, Integer report, Animal pet) {
		super();
		this.name = name;
		this.report = report;
		this.pet = pet;
	}
	

}
