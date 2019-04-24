package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main Menu which allows the user to enter the application or quit
 * 
 * @author danielramirez
 *
 */
public class MainMenu {
	/**
	 * Main stage for application
	 */
	Stage window;
	/**
	 * Main Menu constructor
	 * 
	 * @param primaryStage Main stage
	 */
	public MainMenu(Stage primaryStage) {
		window = primaryStage;
		startMainMenu();
	}
	/**
	 * Displays the main menu to the user
	 */
	private void startMainMenu() {
		//Set up scene
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 700, 500);
		scene.getStylesheets().add("app/application.css");
		window.setScene(scene);
		
		//Label for Title
		Label projectTitleLabel = new Label("Enter Title Here");
		projectTitleLabel.getStyleClass().add("mainTitle");
		
		//Button to take user to player creation
		Button createPlayerButton = new Button("Create New Player");
		createPlayerButton.getStyleClass().add("mainButton");
		createPlayerButton.setOnAction(e -> new PlayerCreationMenu(window));
		
		//Button to exit game
		Button exitButton = new Button("Quit");
		exitButton.getStyleClass().add("mainButton");
		exitButton.setOnAction(e -> window.close());
		
		//Display items to gui
		VBox mainBox = new VBox(projectTitleLabel, createPlayerButton, exitButton);
		mainBox.setSpacing(40);
		bp.setCenter(mainBox);
	}

}
