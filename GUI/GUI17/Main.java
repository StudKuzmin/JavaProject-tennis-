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
	private BorderPane root;
	
	public static void main(String[] args) {
		Application.launch(args);
		
		
	}
	
	@Override
	public void start(Stage stage) {
		root = new BorderPane();
		Scene scene = new Scene(root);
		
		stage.setMaximized(true);
		//stage.setResizable(false);
        stage.setTitle("Client");
        stage.setScene(scene);
		stage.centerOnScreen();
		
		stage.show();
		
		
		// stage.setFullScreen(true);
		// stage.setFullScreenExitHint("");
		// stage.initStyle(StageStyle.TRANSPARENT);
		// stage.initStyle(StageStyle.UNDECORATED);
		
		
		
		Rectangle rec = new Rectangle(100, 150);
		rec.setOnMousePressed(e -> {
			oldX = rec.getTranslateX()-e.getSceneX();
			oldY = rec.getTranslateY()-e.getSceneY();
		});
		rec.setOnMouseDragged(e -> {
			System.out.println("Rec X\t" + rec.getTranslateX());
			rec.setTranslateX(oldX+e.getSceneX());
			rec.setTranslateY(oldY+e.getSceneY());
		});
		
		
		
		
		
		
		 root.setFocusTraversable(true);
        root.requestFocus();
		root.getChildren().addAll(rec);
		
		
		
		//MainScene ms = new MainScene();
		//View v = new View(ms, stage, rec);
		
		//v.start();
		
		

	}
}

class th extends Thread {
	
	@Override
	public void run() {
		
	}
}