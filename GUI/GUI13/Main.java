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
import javafx.stage.StageStyle;



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
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initStyle(StageStyle.UNDECORATED);
		
		View v = new View();
		MainScene ms = new MainScene(v);
		v.sendMainScene(ms);
		v.sendStage(stage);
		
		v.pressPlay();
		v.pressSettings();
		v.pressExit();
		
		
		
		
		stage.setScene(ms.getScene());
		stage.show();
	}
}

