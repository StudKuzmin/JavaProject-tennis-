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
		c.setActionPlay();
		c.setActionSettings();
		c.setActionExit();
		c.display();
		
		Image imgTennis = new Image("./Images/Tennis.png");
		ImageView imgT = new ImageView(imgTennis);
		Image imgPlay = new Image("./Images/Play.png", 50, 50, true, true);
		ImageView imgP = new ImageView(imgPlay);
		Image imgSettings = new Image("./Images/Settings.png", 70, 70, true, true);
		ImageView imgS = new ImageView(imgSettings);
		Image imgExit = new Image("./Images/Exit.png", 50, 50, true, true);
		ImageView imgE = new ImageView(imgExit);
		//imgT.setY(-300);
		imgP.setX(10);
		imgP.setY(-260);
		imgS.setY(-170);
		imgE.setX(10);
		imgE.setY(-70);
		
		//StackPane rootImg = new StackPane(imgP, imgS, imgE);
		
		BorderPane pane = new BorderPane();
		pane.setTop(imgT);
		FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, c.getPlay(), c.getSettings(), c.getExit(), pane);
		root.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}

