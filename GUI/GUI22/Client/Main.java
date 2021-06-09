

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

	public static void main(String[] args) {
		Application.launch(args);	
	}
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Tennis");
		stage.setHeight(500);
		stage.setWidth(500);
		stage.centerOnScreen();
		
		// stage.setFullScreen(true);
		// stage.setFullScreenExitHint("");
		// stage.initStyle(StageStyle.TRANSPARENT);
		// stage.initStyle(StageStyle.UNDECORATED);
		
		MainScene ms = new MainScene();
		View v = new View(ms, stage);
		
		v.start();
		
		// IColorBall_BLUE bb = BallFactory.CreateInstance();
		// bb.print_BLUE();
		// try {
			// IColorBall_RED br = (IColorBall_RED)bb;
			// br.print_RED();
		// } catch (Exception e) {}
		

		
		stage.setScene(ms.getScene());
		stage.show();
	}
}
