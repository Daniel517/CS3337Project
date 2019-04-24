package gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeGUI {
	Stage window;
	public HomeGUI(Stage window) {
		this.window = window;
		setUpScreen();
	}
	private void setUpScreen() {
		BorderPane backBP = new BorderPane();
		BorderPane sideBP = new BorderPane();
		BorderPane mainBP = new BorderPane();
		backBP.setCenter(mainBP);
		backBP.setRight(sideBP);
		Scene scene = new Scene(mainBP, 1200, 1200);
		mainBP.setBackground(new Background(new BackgroundImage(new Image("images/home.png"), null, null, null, null)));
		window.setScene(scene);
	}
}
