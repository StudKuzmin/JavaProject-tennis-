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
	private Bounds bounds;
	private Bounds bounds2;
	
	public Model(Rectangle rec, Circle cir, Bounds bounds, Bounds bounds2) {
		this.cir = cir;
		this.rec = rec;
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
		
		System.out.println("LINE_1");
		Thread_ball tb = new Thread_ball(cir, rec, bounds, bounds2);
		tb.start();
		my m = new my(rec);
		m.start();
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

class my extends Thread {
	Rectangle rec;
	public my(Rectangle rec){
			this.rec = rec;
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println("REEEEEEC X\t" + rec.getLayoutX());
		}
	}
}




class Thread_ball extends Thread {
	AnimB ab;

	
	public Thread_ball(Circle cir, Rectangle rec, Bounds bounds, Bounds bounds2) {	
		ab = new AnimB(cir, rec, bounds, bounds2);
	}

	@Override
	public void run() {
		System.out.println("LINE_3");
		ab.st();
	}
}

class AnimB {
	Circle cir;
	Rectangle rec;
	Bounds bounds2;
	double maxX;
	double maxY;
	double minX;
	double minY;
	
	static double x = 1.0;
	static double y = 1.0;

	

	
	public AnimB() {
		
	}
	
	public AnimB(Circle cir, Rectangle rec, Bounds bounds, Bounds bounds2) {
		this.cir = cir;
		this.rec = rec;
		this.bounds2 = bounds2;

		
		this.maxX = bounds.getMaxX();
		this.maxY = bounds.getMaxY();
		this.minX = bounds.getMinX();
		this.minY = bounds.getMinY();

	}

	public void st() {
		System.out.println("LINE_4");
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
	static private Socket clientConnection;
	static private ObjectOutputStream out;
	static private ObjectInputStream in;
	
	
	public static void st(AnimB ab)
	{
		System.out.println("LINE_5");
		try
		{
			clientConnection = new Socket(InetAddress.getByName("127.0.0.1"), 1111);
			System.out.println("LINE_6");
			while(true) {
					out = new ObjectOutputStream(clientConnection.getOutputStream());
					in = new ObjectInputStream(clientConnection.getInputStream());
					
					
					Object obj = ab.getRecX();
					sendData(obj);
					obj = ab.getRecY();
					sendData(obj);
					
					
					
					
					
					
					
					obj = in.readObject();
					/*System.out.print("X:\t");*/ getData(obj);
					double db = (double)obj;
					ab.setX(db);
					
					obj = in.readObject();
					/*System.out.print("Y:\t");*/ getData(obj);
					double db2 = (double)obj;
					ab.setY(db2);
					
					System.out.println();
				}
		   
		} catch (Exception e) { System.out.println("Error: " + e); }
	}
	

	private static void sendData(Object obj){
		try {
			out.writeObject(obj);
		} catch (Exception e) { System.out.println("Error: " + e); }
	}

	private static void getData(Object obj) {
		try {
			double str = (double)obj;
			//System.out.println(str);
		} catch (Exception e) { System.out.println("Error: " + e); }
	}
	
}