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
	
	private double oldX, oldY;
	
	// private ProcessingPlayBtn ppb;
	
	public Model() {
		// ppb = new ProcessingPlayBtn();
	}
	
	public void NameBtnPlay(String s){
		play = s;
	}
	public void NameBtnSettings(String s){
		settings = s;
	}
	public void NameBtnExit(String s){
		exit = s;
	}
	
	// public void ActionBtnPlay(){
		// MyThread T = new MyThread();
		// T.setProcessingPlayBtn(ppb);
		// T.start();
	// }
	// public void ActionBtnSettings(){
		// MyThread T2 = new MyThread();
		// T2.setProcessingPlayBtn(ppb);
		// T2.start();
	// }
	// public void ActionBtnExit(){
		
	// }
	
	
	
	
	
	
	
	
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








// class MyThread extends Thread {
	// private ProcessingPlayBtn ppb = new ProcessingPlayBtn();
	
	// public void setProcessingPlayBtn(ProcessingPlayBtn ppb) {
		// this.ppb = ppb;
	// }
	
	
	// @Override
	// public void run() {
		// ppb.startProcessing();
	// }
// }



// class ProcessingPlayBtn {
	// private int time = 5;
		
	// public synchronized void startProcessing() {
		// while (time > 0) {
				// System.out.println(time);
				// time--;
				// try { Thread.sleep(1000); } 
				// catch (Exception e) { System.out.println(e); }
		// }
		// time = 5;
	// }
// }