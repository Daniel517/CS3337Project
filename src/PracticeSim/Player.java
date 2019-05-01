package PracticeSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import PracticeSim.background.GameObject;
import PracticeSim.background.Handler;
import PracticeSim.background.ID;

public class Player extends GameObject{
	
	Handler handler;

	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH);
		y = Game.clamp(y, 0, Game.HEIGHT);
		
	}
	

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	@Override
	public void awayAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
