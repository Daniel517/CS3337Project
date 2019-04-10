package PracticeSim.Assets;

import java.awt.image.BufferedImage;
import PracticeSim.Assets.ImageLoader;;

public class Assets {
	
public static BufferedImage home, park,death,list,dog,cat,bird,action;
	
	public static void init() {
		
		home = ImageLoader.loadImage("/textures/home.png");
		park = ImageLoader.loadImage("/textures/park.jpg");
		death = ImageLoader.loadImage("/textures/unknown.jpg");
		list = ImageLoader.loadImage("/textures/AnimalListSection.png");
		dog =ImageLoader.loadImage("/textures/dog.png");
		cat = ImageLoader.loadImage("/textures/cat2.png");
		bird = ImageLoader.loadImage("/textures/bird.jpg");
		action = ImageLoader.loadImage("/textures/ActionSection.png");
		
	}

}
