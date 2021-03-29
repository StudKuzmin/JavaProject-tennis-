import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class Controller {
	Button play = new Button("Play!");			// To Do Значок геймпада
	Button settings = new Button("Settings"); 	// To Do значок настройки
	Button exit = new Button("Exit"); 			// To Do значок выхода
	
	public Controller() {
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
	}
	
	public void setActionPlay() {
		play.setOnAction(event -> {
			play.setText("You're playing..");
		});
	}
	public void setActionSettings() {
		settings.setOnAction(event -> {
			settings.setText("Settings processing..");
		});
	}
	public void setActionExit() {
		exit.setOnAction(event -> {
			exit.setText("Exit the game..");
		});
	}
	
	public Button getPlay() {
		return play;
	}
	public Button getSettings() {
		return settings;
	}
	public Button getExit() {
		return exit;
	}
	
}