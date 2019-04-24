package app;
	
import gui.HomeGUI;
import gui.MainMenu;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			@SuppressWarnings("unused")
			//MainMenu root = new MainMenu(primaryStage);
			HomeGUI root = new HomeGUI(primaryStage);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
