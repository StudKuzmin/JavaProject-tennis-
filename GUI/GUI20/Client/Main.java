import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	double oldX, oldY = 0;
	Rectangle rec;
	public static void main(String[] args) {
		Application.launch(args);
		
		
	}
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Tennis");
		stage.setHeight(500);
		stage.setWidth(500);
		stage.centerOnScreen();
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initStyle(StageStyle.UNDECORATED);
		
		MainScene ms = new MainScene();
		View v = new View(ms, stage);
		
		v.start();

		
		stage.setScene(ms.getScene());
		stage.show();
	}
}
