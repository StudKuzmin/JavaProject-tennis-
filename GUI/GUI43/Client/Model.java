import javafx.application.Platform;
import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

import java.net.*;
import java.io.*;

public class Model {
	private String play;
	private String settings;
	private String exit;
	
	private MainScene ms;
	
	private Circle cir;
	private Rectangle rec;
	
	public Model(Rectangle rec, Circle cir, MainScene ms) {
		this.cir = cir;
		this.rec = rec;
		this.ms = ms;
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
	
	
	public void playProcess() {
		
		Thread_ball tb = new Thread_ball(cir, rec, ms);
		tb.start();
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




class Thread_ball extends Thread {
	AnimationBall ab;

	
	public Thread_ball(Circle cir, Rectangle rec, MainScene ms) {	
		ab = new AnimationBall(cir, rec, ms);
	}

	@Override
	public void run() {
		ab.st();
	}
}






class AnimationBall {
	Circle cir;
	Rectangle rec;
	Bounds boundsRec;
	double maxX;
	double maxY;
	double minX;
	double minY;
	
	static double x = 1.0;
	static double y = 1.0;

	MainScene ms;

	
	public AnimationBall() {}
	
	public AnimationBall(Circle cir, Rectangle rec, MainScene ms) {
		this.cir = cir;
		this.rec = rec;
		this.ms = ms;
	}

	public void st() {
		CCnet Cc = new CCnet(this, ms);
		Cc.st();
	}
	
	public void setX(double x) {
		cir.setLayoutX(x);
	}
	
	public void setY(double y) {
		cir.setLayoutY(y);
	}
	
	
	public double getRecX() {
		return rec.getLayoutX();
	}
	
	public double getRecY() {
		return rec.getLayoutY();
	}
}






class CCnet {
	
	Client c;
	AnimationBall ab;
	MainScene ms;
	
	public CCnet(AnimationBall ab, MainScene ms) {
		c = new Client();
		this.ab = ab;
		this.ms = ms;
	}

	public void st() {
		c.st(ab, ms);
	}
}



class Client
{
	private MainScene ms;
	public void st(AnimationBall ab, MainScene ms)
	{
		this.ms = ms;
		Socket clientConnection = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		int playerID = 0;
		int countPlayers = 1;
		int pCountPlayers = 0;
		double otherRecX, otherRecY = 0;
		try
		{
			clientConnection = new Socket(InetAddress.getLocalHost(), 1111);
			out = new ObjectOutputStream(clientConnection.getOutputStream());
			in = new ObjectInputStream(clientConnection.getInputStream());
			
			// Принимаем ID нового игрока
			Object obj = in.readObject();
			playerID = (int)obj;
			while(true) {	
					// Принимаем количество подключившихся игроков
					obj = in.readObject();
					countPlayers = (int)obj;
					
					if (countPlayers > 1 && countPlayers != pCountPlayers) {  
							Platform.runLater(new Runnable() {
								public void run() {
									ms.setRec();
								}
							});
						pCountPlayers = countPlayers;
					}
					// Отправляем ID текущего игрока клиента
					out.writeObject(playerID);
					
					// Отправляем координаты ракетки текущего игрока
					obj = ab.getRecX();
					out.writeObject(obj);
					obj = ab.getRecY();
					out.writeObject(obj);
					
					// Принимаем координаты ракетки другого игрока
					obj = in.readObject();
					otherRecX = (double)obj;
					obj = in.readObject();
					otherRecY = (double)obj;
					sendRecXY(otherRecX, otherRecY);
					
					// Принимаем координаты шара
					obj = in.readObject();
					double db = (double)obj;
					//System.out.print("X:\t"); System.out.println(db);
					ab.setX(db);
					obj = in.readObject();
					double db2 = (double)obj;
					//System.out.print("Y:\t"); System.out.println(db2);;
					ab.setY(db2);
					
					
					
					System.out.println();
				}
		   
		} catch (Exception e) { System.out.println("Error: " + e); }
	}
	
	public void sendRecXY(double otherRecX, double otherRecY) {
		ms.setRecXY(otherRecX, otherRecY);
	}
}