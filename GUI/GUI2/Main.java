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
		
		Controller c = new Controller();
		c.setActionPlay();
		c.setActionSettings();
		c.setActionExit();
		
		View v = new View();
		
		//FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, c.getPlay(), c.getSettings(), c.getExit());
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
