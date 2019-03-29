package application;
	
import java.util.ArrayList;

import application.background.Simulator;
import gui.MainMenu;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//@SuppressWarnings("unused")
			//MainMenu root = new MainMenu(primaryStage);
			//primaryStage.show();
			Simulator sim = new Simulator("PETS Simulator", 1300,1300/12*9);
			sim.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
