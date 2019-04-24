package PracticeSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import PracticeSim.background.GameObject;
import PracticeSim.background.Handler;
import PracticeSim.background.ID;

public class WildAnimal extends GameObject{

	Handler handler;
	int size= 60;
	
	public WildAnimal(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 15;
		velY = 15;
	}

	public Rectangle getBounds() {	
		return new Rectangle(x,y,size,size);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
	
		
		if(y <= 0 || y >= Game.HEIGHT-38)
			velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-300)
			velX *= -1;
				
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, size, size);
	}
	
	

}
