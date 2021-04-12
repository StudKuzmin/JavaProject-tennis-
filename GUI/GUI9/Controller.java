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
	//private View v = new View();
	
	public void PressPlay() {
		m.NameBtnPlay("Loading the game..");
		btnPlay(m);
	}
	public void PressSettings() {
		m.NameBtnSettings("Settings processing..");
		btnSettings(m);
	}
	public void PressExit() {
		m.NameBtnExit("Exit the game..");
		btnExit(m);
	}
	
	// public void display() {
		// btnPlay(m.getPlay());
		// btnSettings(m.getSettings());
		// btnExit(m.getExit());
	// }
	
	
	
	
	
	
	
	
	
	
	
	
	public Button getBtnPlay(){
		return getPlay();
	}
	public Button getBtnSettings(){
		return getSettings();
	}
	public Button getBtnExit(){
		return getExit();
	}
}