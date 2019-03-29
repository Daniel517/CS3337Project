package application;

public class Handler {
	
	private Simulator sim;
	
	public Handler(Simulator sim) {
		this.sim = sim;
	}

	
	public int getWidth() {
		return sim.getWidth();
	}
	public int getHeight() {
		return sim.getHeight();
	}
	
	
	public Simulator getSim() {
		return sim;
	}

	public void setSim(Simulator sim) {
		this.sim = sim;
	}
	

}
