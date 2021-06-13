
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
	
	private double oldX, oldY;
	
	private Circle cir;
	private Rectangle rec;
	private Rectangle rec2;
	private Bounds bounds;
	private Bounds bounds2;
	
	public Model(Rectangle rec, Rectangle rec2, Circle cir, Bounds bounds, Bounds bounds2) {
		this.cir = cir;
		this.rec = rec;
		this.rec2 = rec2;
		this.bounds = bounds;
		this.bounds2 = bounds2;
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
		
		Thread_ball tb = new Thread_ball(cir, rec, rec2, bounds, bounds2);
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
	AnimB ab;

	
	public Thread_ball(Circle cir, Rectangle rec, Rectangle rec2, Bounds bounds, Bounds bounds2) {	
		ab = new AnimB(cir, rec, rec2, bounds, bounds2);
	}

	@Override
	public void run() {
		ab.st();
	}
}






class AnimB {
	Circle cir;
	Rectangle rec;
	Rectangle rec2;
	Bounds bounds2;
	double maxX;
	double maxY;
	double minX;
	double minY;
	
	static double x = 1.0;
	static double y = 1.0;

	

	
	public AnimB() {
		
	}
	
	public AnimB(Circle cir, Rectangle rec, Rectangle rec2, Bounds bounds, Bounds bounds2) {
		this.cir = cir;
		this.rec = rec;
		this.rec2 = rec2;
		this.bounds2 = bounds2;

		
		this.maxX = bounds.getMaxX();
		this.maxY = bounds.getMaxY();
		this.minX = bounds.getMinX();
		this.minY = bounds.getMinY();

	}

	public void st() {
		CCnet Cc = new CCnet(this);
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
	
	public double getRec2X() {
		return rec2.getLayoutX();
	}
	
	public double getRec2Y() {
		return rec2.getLayoutY();
	}

	
}






class CCnet {
	
	Client c;
	AnimB ab;
	
	public CCnet(AnimB ab) {
		c = new Client();
		this.ab = ab;
	}

	public void st() {
		c.st(ab);
	}
}







class Client
{
	public static void st(AnimB ab)
	{
		Socket clientConnection = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try
		{
			clientConnection = new Socket(InetAddress.getLocalHost(), 1111);
			out = new ObjectOutputStream(clientConnection.getOutputStream());
			in = new ObjectInputStream(clientConnection.getInputStream());
			while(true) {	
					Object obj = ab.getRecX();
					out.writeObject(obj);
					obj = ab.getRecY();
					out.writeObject(obj);
					
					obj = ab.getRec2X();
					out.writeObject(obj);
					obj = ab.getRec2Y();
					out.writeObject(obj);
					
					obj = in.readObject();
					double db = (double)obj;
					System.out.print("X:\t"); System.out.println(db);
					ab.setX(db);
					
					obj = in.readObject();
					double db2 = (double)obj;
					System.out.print("Y:\t"); System.out.println(db2);;
					ab.setY(db2);
					
					System.out.println();
				}
		   
		} catch (Exception e) { System.out.println("Error: " + e); }
	}
	

	// private static void sendData(Object obj){
		// try {
			// out.writeObject(obj);
		// } catch (Exception e) { System.out.println("Error: " + e); }
	// }

	// private static void getData(Object obj) {
		// try {
			// double str = (double)obj;
			// System.out.println(str);
		// } catch (Exception e) { System.out.println("Error: " + e); }
	// }
	
}