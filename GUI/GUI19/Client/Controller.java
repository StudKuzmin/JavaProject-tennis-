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
	
	public void pressPlay_Controller(Model m) {
		m.NameBtnPlay("Loading the game..");
		m.playProcess();
	}
	public void pressSettings_Controller(Model m) {
		m.NameBtnSettings("Settings processing..");
	}
	public void pressExit_Controller(Model m) {
		m.NameBtnExit("Exit the game..");
	}
}