import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class Model {
	private String play;
	private String settings;
	private String exit;
	
	public void ActionBtnPlay(String s){
		play = s;
	}
	public void ActionBtnSettings(String s){
		settings = s;
	}
	public void ActionBtnExit(String s){
		//System.out.println(str);
		exit = s;
	}
	
	
	
	
	
	
	
	
	public String getPlay() {
		return play;
	}
	public String getSettings() {
		return settings;
	}
	public String getExit() {
		return exit;
	}
}