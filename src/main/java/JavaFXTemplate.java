import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Geo Gonzalez Homework 3");

		Button b1 = new Button("button 1");
		Button b2 = new Button("button 2");
		TextField tf1 = new TextField();
		tf1.setPromptText("enter text here then press button 1");
		TextField tf2 = new TextField("final string goes here");
		tf2.setEditable(false);
		BorderPane bPane = new BorderPane();
		bPane.setCenter(tf1);
		bPane.setRight(tf2);
		VBox buttonVBox = new VBox(b1, b2); 
		bPane.setLeft(buttonVBox);

		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent myAction) {
				tf2.setText(tf1.getText() + ": from the center text field!");
				b1.setDisable(true);
				b1.setText("pressed");
			}
		});

		b2.setOnAction(e->{
			tf1.clear();
			tf2.clear();
			tf2.setText("final string goes here");
			b1.setDisable(false);
			b1.setText("button 1");
		});
				
		Scene scene = new Scene(bPane, 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
