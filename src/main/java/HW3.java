import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HW3 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Set title for the window
		primaryStage.setTitle("Geo Gonzalez Homework 3");

		//Create buttons, textfields, vbox, and borderpane
		Button b1 = new Button("button 1");
		Button b2 = new Button("button 2");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField("final string goes here");
		VBox buttonVBox = new VBox(b1, b2);
		BorderPane bPane = new BorderPane();
		
		//Set prompt for 1st text field
		tf1.setPromptText("enter text here then press button 1");
		//Disable the 2nd text field
		tf2.setEditable(false);
		//Give textfield 2 its own vbox, in order to center it
		VBox tf2Box = new VBox(tf2);
		//Add items to borderpane
		bPane.setCenter(tf1);
		bPane.setRight(tf2Box);
		bPane.setLeft(buttonVBox);


		//Event handler for button 1
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent myAction) {
				tf2.setText(tf1.getText() + ": from the center text field!");
				b1.setDisable(true);
				b1.setText("pressed");
			}
		});
		//Event handler for button 2
		b2.setOnAction(e->{
			tf1.clear();
			tf2.clear();
			tf2.setText("final string goes here");
			b1.setDisable(false);
			b1.setText("button 1");
		});

		//////////////////////////////////////////////////////////////
		//Unrequired Appearance Changes
		//////////////////////////////////////////////////////////////

		//Coloring -
		//All of this can just be replaced with setStyle -_-

		// Color mainGrey = Color.web("0x36393f");
		// BackgroundFill mainFill = new BackgroundFill(mainGrey, CornerRadii.EMPTY, Insets.EMPTY);
		// Background mainBackground = new Background(mainFill);
		// bPane.setBackground(mainBackground);
		// Color accentGrey = Color.web("0x40444b");
		// BackgroundFill accentFill = new BackgroundFill(accentGrey, CornerRadii.EMPTY, Insets.EMPTY);
		// Background accentBackground = new Background(accentFill);
		// b1.setBackground(accentBackground);
		// b1.setTextFill(Color.WHITE);
		// b2.setBackground(accentBackground);
		// b2.setTextFill(Color.WHITE);

		//Border Pane Background color
		bPane.setStyle("-fx-background-color: #36393f;");
		//Button Colors & Font
		b1.setStyle("-fx-background-color: #379b57; -fx-text-fill: #ffffff; -fx-pref-width: 200px;");
		b2.setStyle("-fx-background-color: #e84144; -fx-text-fill: #ffffff; -fx-pref-width: 200px;");
		b1.setFont(Font.loadFont("file:src/main/resources/p5hatty.ttf", 35));
		b2.setFont(Font.loadFont("file:src/main/resources/p5hatty.ttf", 35));

		//Text Field Colors & Font
		tf1.setStyle("-fx-text-inner-color: #ffffff;-fx-background-color: #40444b; -fx-pref-width: 475px;");
		tf2.setStyle("-fx-text-inner-color: #40444b;-fx-background-color: #2f3136; -fx-pref-height: 200px");
		tf1.setFont(Font.loadFont("file:src/main/resources/p5hatty.ttf", 35));
		tf2.setFont(Font.loadFont("file:src/main/resources/p5hatty.ttf", 35));
		//Center buttons and textfield 2 vertically
		buttonVBox.setAlignment(Pos.CENTER);
		tf2Box.setAlignment(Pos.CENTER);
		//Disable tab taking you to textfield 2
		tf2.setFocusTraversable(false);

		//Bonus label at the top to give program a title
		Label myLabel = new Label("CS 342 Homework 3: Java FX Intro");
		myLabel.setStyle("-fx-text-fill: #ffffff;");
		myLabel.setFont(Font.loadFont("file:src/main/resources/p5hatty.ttf", 35));
		HBox titleBox = new HBox(myLabel);
		titleBox.setStyle("-fx-background-color: #5865f2;");
		titleBox.setAlignment(Pos.CENTER);
		bPane.setTop(titleBox);

		//Set spacing in button box so buttons are not right on top of each other
		buttonVBox.setSpacing(20);
		//Icon for the program
		primaryStage.getIcons().add(new Image("file:src/main/resources/p5.png"));
		//////////////////////////////////////////////////////////////
		//Unrequired Appearance Changes Over
		//////////////////////////////////////////////////////////////

		//Create and set the main scene, then show
		Scene scene = new Scene(bPane);
		//primaryStage.initStyle(StageStyle.UNDECORATED); //For disabling title bar in future
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
