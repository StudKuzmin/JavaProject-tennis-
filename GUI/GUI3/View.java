import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class View {
	private Button play = new Button("Play!");			// To Do Значок геймпада
	private Button settings = new Button("Settings"); 	// To Do значок настройки
	private Button exit = new Button("Exit"); 			// To Do значок выхода
	
	private String str;
	
	public View() {
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
		
	}
	
	
	public void btnPlay(String str){
		System.out.println(str);
		play.setOnAction(event -> {
			play.setText(str);
		});
	}
	public void btnSettings(String str){
		System.out.println(str);
		settings.setOnAction(event -> {
			settings.setText(str);
		});
	}
	public void btnExit(String str){
		System.out.println(str);
		exit.setOnAction(event -> {
			exit.setText(str);
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