import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.*;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class View extends Controller {
	private Button play;		
	private Button settings;
	private Button exit;	

	
	private Image imgTennis;
	private ImageView imgT;
	private Image imgPlay;
	private ImageView imgP;
	private Image imgSettings;
	private ImageView imgS;
	private Image imgExit;
	private ImageView imgE;
	
	private BorderPane Bp;
	private Model m;
	private String str;
	
	
	public View(){
		imgTennis = new Image("./Images/Tennis.png");
		imgT = new ImageView(imgTennis);
		imgPlay = new Image("./Images/Play.png", 50, 50, true, true);
		imgP = new ImageView(imgPlay);
		imgSettings = new Image("./Images/Settings.png", 70, 70, true, true);
		imgS = new ImageView(imgSettings);
		imgExit = new Image("./Images/Exit.png", 50, 50, true, true);
		imgE = new ImageView(imgExit);
		
		
		play = new Button("Play!", /*Bp*/ imgP);	
		settings = new Button("Settings", imgS);
		exit = new Button("Exit", imgE); 
		
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
		
		m = new Model();
	}
	
	public void pressPlay(){
		pressPlay_Controller(m);
		
		play.setOnAction(event -> {
			play.setText(m.getPlay());
			//m.ActionBtnPlay();
		});
	}
	public void pressSettings(){
		pressSettings_Controller(m);
		
		settings.setOnAction(event -> {
			settings.setText(m.getSettings());
			//m.ActionBtnPlay();
		});
	}
	public void pressExit(){
		pressExit_Controller(m);
		
		exit.setOnAction(event -> {
			exit.setText(m.getExit());
		});
	}
	
	
	public Button getPlay(){
		return play;
	}
	public Button getSettings(){
		return settings;
	}
	public Button getExit(){
		return exit;
	}
}