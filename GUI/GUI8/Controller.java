import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class Controller extends View {
	private Model m = new Model();
	
	public void PressPlay() {
		m.ActionBtnPlay("Loading the game..");
	}
	public void PressSettings() {
		m.ActionBtnSettings("Settings processing..");
	}
	public void PressExit() {
		m.ActionBtnExit("Exit the game..");
	}
	
	public void display() {
		btnPlay(m.getPlay());
		btnSettings(m.getSettings());
		btnExit(m.getExit());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// TO DO инкапсулировать в отдельный класс Root
	public Button getPlay_(){
		return getPlay();
	}
	public Button getSettings_(){
		return getSettings();
	}
	public Button getExit_(){
		return getExit();
	}
}