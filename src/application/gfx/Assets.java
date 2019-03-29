package application.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage home, park,death,list;
	
	public static void init() {
		
		home = ImageLoader.loadImage("/textures/home.png");
		park = ImageLoader.loadImage("/textures/park.jpg");
		death = ImageLoader.loadImage("/textures/unknown.jpg");
		list = ImageLoader.loadImage("/textures/AnimalListSection.png");
	}

}
