import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
		
		
	}
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Tennis");
		stage.setHeight(500);
		stage.setWidth(500);
		stage.centerOnScreen();
		
		Button play = new Button("Play!");			// To Do Значок геймпада
		play.setPrefSize(300, 80);
		Button settings = new Button("Settings"); 	// To Do значок настройки
		settings.setPrefSize(300, 80);
		Button exit = new Button("Exit"); 			// To Do значок выхода
		exit.setPrefSize(300, 80);
		
		FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, play, settings, exit);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}

