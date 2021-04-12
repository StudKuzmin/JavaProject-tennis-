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
	
	Image imgTennis;
	ImageView imgT;
	Image imgPlay;
	ImageView imgP;
	Image imgSettings;
	ImageView imgS;
	Image imgExit;
	ImageView imgE;
	
	BorderPane Bp;
	
	Res r = new Res();
	
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
		
		// Bp = new BorderPane();
		// Bp.setLeft(imgP);
		
		
		play = new Button("Play!", /*Bp*/ imgP);	
		settings = new Button("Settings", imgS);
		exit = new Button("Exit", imgE); 
		
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
		
	}
	
	
	public void btnPlay(String str){
		System.out.println(str);
		play.setOnAction(event -> {
			MyThread T1 = new MyThread();
			T1.setName("T1");
			T1.setR(r);
			T1.start();
			play.setText(str);
		});
	}
	public void btnSettings(String str){
		System.out.println(str);
		settings.setOnAction(event -> {
			MyThread T2 = new MyThread();
			T2.setName("T2");
			T2.setR(r);
			T2.start();
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

class MyThread extends Thread {
	int i = 1;
	Res r = new Res();
	
	public void setR(Res r) {
		this.r = r;
	}
	
	@Override
	public void run() {
		r.ch();
	}
}

class Res {
	int i = 1;
	public synchronized void ch() {
			while(true) { 
				System.out.println(i++); 
				try { Thread.sleep(1000); } 
				catch (Exception e) { System.out.println(e); }
		}
	}
}