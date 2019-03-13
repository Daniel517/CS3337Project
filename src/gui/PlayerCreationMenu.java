package gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerCreationMenu {
	Stage window;
	public PlayerCreationMenu(Stage primaryStage) {
		window = primaryStage;
		startSinglePetPlayerCreationMenu();
	}
	private void startSinglePetPlayerCreationMenu() {
		//Set up scene
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 700, 500);
		scene.getStylesheets().add("application/application.css");
		window.setScene(scene);
		
		//Label for heading
		Label headingLabel = new Label("Create Character:");
		headingLabel.getStyleClass().add("descriptionLabel");
		
		//Label for user's info
		Label userNameLabel = new Label("User's Name: ");
		userNameLabel.getStyleClass().add("nameLabel");
		
		//TextField for user to input name
		TextField userNameInput = new TextField();
		
		//HBox to horizontally align user information
		HBox userInfoBox = new HBox(userNameLabel, userNameInput);
		userInfoBox.setSpacing(40);
		
		//Label for pet's info (Pet Type)
		Label petTypeLabel = new Label("Pet Type: ");
		petTypeLabel.getStyleClass().add("nameLabel");
		
		//Drop box option for pet types and pet breed type
		ChoiceBox<String> petType = new ChoiceBox<String>();
		petType.getItems().addAll("Select Pet", "Dog", "Cat", "Bird");
		petType.setValue("Select Pet");
		ChoiceBox<String> petBreed = new ChoiceBox<String>();
		petType.setOnAction(e -> setUpSecondChoiceBox(petBreed, petType.getValue()));
		
		//Label for pet's info (Pet Name)
		Label petNameLabel = new Label("Pet's Name: ");
		petNameLabel.getStyleClass().add("nameLabel");
		
		//TextField for user to input pet name
		TextField petNameInput = new TextField();
		
		//HBox to horizontally align pet information
		HBox petInfoBox = new HBox(petTypeLabel, petType, petBreed, petNameLabel, petNameInput);
		petInfoBox.setSpacing(20);
		
		//Button to add another pet
		Button addPetButton = new Button("+");
		addPetButton.setOnAction(e -> startTwoPetPlayerCreationMenu(userNameInput.getText(), petNameInput.getText(), petType.getValue(), petBreed.getValue()));
		
		//VBox for all item to be displayed in gui
		VBox box2 = new VBox(headingLabel, userInfoBox, petInfoBox, addPetButton);
		box2.setSpacing(50);
		bp.setCenter(box2);
		
		//Send info to module
		//Add button to handle when done with info
	}
	private void startTwoPetPlayerCreationMenu(String userNameIn, String pet1NameIn, String pet1TypeIn, String pet1BreedIn) {
		//Set up scene
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 700, 500);
		scene.getStylesheets().add("application/application.css");
		window.setScene(scene);
		
		//Label for heading
		Label headingLabel = new Label("Create Character:");
		headingLabel.getStyleClass().add("descriptionLabel");
		
		//Label for user's info
		Label userNameLabel = new Label("Name: ");
		userNameLabel.getStyleClass().add("nameLabel");
		
		//TextField for user to input name
		TextField nameInput = new TextField();
		nameInput.setText(userNameIn);
		
		//HBox to horizontally align user information
		HBox userInfoBox = new HBox(userNameLabel, nameInput);
		userInfoBox.setSpacing(40);
		
		//Label for first pet's info (Pet Type)
		Label pet1TypeLabel = new Label("Pet Type: ");
		pet1TypeLabel.getStyleClass().add("nameLabel");
		
		//Drop box option for first pet type and pet breed
		ChoiceBox<String> pet1Type = new ChoiceBox<String>();
		pet1Type.getItems().addAll("Select Pet", "Dog", "Cat", "Bird");
		pet1Type.setValue(pet1TypeIn);
		ChoiceBox<String> pet1Breed = new ChoiceBox<String>();
		setUpSecondChoiceBox(pet1Breed, pet1Type.getValue(), pet1BreedIn);
		pet1Type.setOnAction(e -> setUpSecondChoiceBox(pet1Breed, pet1Type.getValue()));
		
		//Label for pet
		Label pet1NameLabel = new Label("Pet's Name: ");
		pet1NameLabel.getStyleClass().add("nameLabel");
		
		//TextFIeld for user to input first pet's name
		TextField pet1NameInput = new TextField();
		pet1NameInput.setText(pet1NameIn);
		
		//HBox to horizontally align pet information
		HBox pet1InfoBox = new HBox(pet1TypeLabel, pet1Type, pet1Breed, pet1NameLabel, pet1NameInput);
		pet1InfoBox.setSpacing(20);
		
		//Label for pet
		Label pet2TypeLabel = new Label("Pet Type: ");
		pet2TypeLabel.getStyleClass().add("nameLabel");
		
		//Drop box option for pet types
		ChoiceBox<String> pet2Type = new ChoiceBox<String>();
		pet2Type.getItems().addAll("Select Pet", "Dog", "Cat", "Bird");
		pet2Type.setValue("Select Pet");
		Platform.runLater(() -> pet2Type.requestFocus()); //Request focus since info on other pet is already filled
		ChoiceBox<String> pet2Breed = new ChoiceBox<String>();
		pet2Type.setOnAction(e -> setUpSecondChoiceBox(pet2Breed, pet2Type.getValue()));
		
		//Label for pet
		Label pet2NameLabel = new Label("Pet's Name: ");
		pet2NameLabel.getStyleClass().add("nameLabel");
		
		//TextFIeld for user to input pet name
		TextField pet2NameInput = new TextField();
		
		//HBox to horizontally align pet information
		HBox pet2InfoBox = new HBox(pet2TypeLabel, pet2Type, pet2Breed, pet2NameLabel, pet2NameInput);
		pet2InfoBox.setSpacing(20);
		
		//Done Button -----CHANGE-------
		Button button = new Button("Tester");
		
		//VBox for all item to be displayed in gui
		VBox allItems = new VBox(headingLabel, userInfoBox, pet1InfoBox, pet2InfoBox, button);
		allItems.setSpacing(50);
		bp.setCenter(allItems);
	}
	private void setUpSecondChoiceBox(ChoiceBox<String> petBreed, String petType) {
		petBreed.getItems().clear();
		switch (petType) {
		case "Dog":
			petBreed.getItems().addAll("Select Breed", "Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese");
			petBreed.setValue("Select Breed");
			break;
		case "Cat":
			petBreed.getItems().addAll("Select Breed", "Siamese", "Tabicat", "Persian", "Sphinx");
			petBreed.setValue("Select Breed");
			break;
		case "Bird":
			petBreed.getItems().addAll("Select Breed", "Pigeon", "Hawk", "Parrot", "Parakeet");
			petBreed.setValue("Select Breed");
		}
	}
	private void setUpSecondChoiceBox(ChoiceBox<String> petBreed, String petType, String breedType) {
		petBreed.getItems().clear();
		switch (petType) {
		case "Dog":
			petBreed.getItems().addAll("Select Breed", "Pitbull", "Rat Terrier", "Poodle", "Husky", "Maltese");
			petBreed.setValue(breedType);
			break;
		case "Cat":
			petBreed.getItems().addAll("Select Breed", "Siamese", "Tabicat", "Persian", "Sphinx");
			petBreed.setValue(breedType);
			break;
		case "Bird":
			petBreed.getItems().addAll("Select Breed", "Pigeon", "Hawk", "Parrot", "Parakeet");
			petBreed.setValue(breedType);
		}
	}
}
