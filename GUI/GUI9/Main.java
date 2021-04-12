import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.*;
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
		MainScene ms = new MainScene(c);
		
		c.PressPlay();
		c.PressSettings();
		c.PressExit();
		//c.display();

		
		
		stage.setScene(ms.getScene());
		stage.show();
	}
}

