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

public class View {
	private Button play;		
	private Button settings;
	private Button exit;	
	
	
	
	private Button back;

	
	Image imgTennis;
	ImageView imgT;
	Image imgPlay;
	ImageView imgP;
	Image imgSettings;
	ImageView imgS;
	Image imgExit;
	ImageView imgE;
	
	BorderPane Bp;
	

	
	private String str;
	
	public View() {
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
		
		back = new Button("Back");
		
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
		back.setPrefSize(300, 80);
		
	}
	
	
	public void btnPlay(Model m, Stage stage){
		System.out.println(m.getPlay());
		play.setOnAction(event -> {
			play.setText(m.getPlay());
			m.ActionBtnPlay(stage);
		});
	}
	public void btnSettings(Model m){
		System.out.println(m.getSettings());
		settings.setOnAction(event -> {
			settings.setText(m.getSettings());
			m.ActionBtnSettings();
		});
	}
	public void btnExit(Model m){
		System.out.println(m.getExit());
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
	public Button getBack(){
		return back;
	}
}