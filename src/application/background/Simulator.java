package application.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import application.animalList.AnimalList;
import application.gfx.Assets;
import application.gfx.ImageLoader;
import application.states.CreationMenu;
import application.states.GameState;
import application.states.MenuState;
import application.states.State;
import gui.Display;

public class Simulator implements Runnable{
	//I think i need to make a player class becasue they
	//would be the only one to be able to move the list.
	public Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	//States
	private State gameState;
	private State menuState;
	private State creationMenu;
	//Input
	private KeyManager keyManager;
	private Handler handler;
	
	private AnimalList animalList;
	
	public Simulator(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
		animalList = new AnimalList(handler);
	}
	
	public void init()
	{
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		creationMenu = new CreationMenu(handler);
		State.setState(gameState);
	}
	
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick= 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: "+ ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	private void tick() {
		keyManager.tick();
		animalList.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
		
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		animalList.render(g);
		
		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
