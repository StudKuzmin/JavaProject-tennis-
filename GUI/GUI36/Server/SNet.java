

import java.net.*;
import java.io.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.geometry.Bounds;
import javafx.stage.StageStyle;





public class SNet extends Application
{
	private Circle cir;
	
	
	
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);


		//stage.setMaximized(true);
        stage.setTitle("Server");
        stage.setScene(scene);
		
		stage.show();
		
		cir = new Circle();
		cir = new Circle(15, Color.BLUE);
		cir.relocate(100, 100);


		// Чтобы могли управлять мячом
        root.setFocusTraversable(true);
        root.requestFocus();
		
		root.getChildren().add(cir);
		
		Bounds bounds = root.getBoundsInLocal();
		
		Thread_ball t = new Thread_ball(cir, bounds);
		t.start();
		
		
    }
}

class Thread_ball extends Thread {	
	AnimB an;

	public Thread_ball(Circle cir, Bounds bounds) {	
		an = new AnimB(cir, bounds);
	}

	@Override
	public void run() {
		an.st();
	}
}


class AnimB {
	Circle cir;
	double maxX;
	double maxY;
	double minX;
	double minY;
	
	static double x = 1.0;
	static double y = 1.0;

	boolean key = false;
	Rectangle rec;
	Rectangle[] r;
	
	
	Bounds bounds2;
	
	int i = 0;
	int[] playerID;
	int playerIDnow;
	
	public AnimB() {
		
	}
	
	public AnimB(Circle cir, Bounds bounds) {
		this.cir = cir;
		
		rec = new Rectangle(100,200);
		r = new Rectangle[4];
		playerID = new int[4];
		bounds2 = rec.getBoundsInLocal();
		
	
		
		this.maxX = bounds.getMaxX();
		this.maxY = bounds.getMaxY();
		this.minX = bounds.getMinX();
		this.minY = bounds.getMinY();
	}

	public void st() {
		Thread_snet ts = new Thread_snet(this);
		ts.start();
		
		while(key == false) { System.out.println("LINE"); }
		while(true) {
			try {
			 cir.setLayoutX(cir.getLayoutX() + x);
			 cir.setLayoutY(cir.getLayoutY() + y);
			 
			 Thread.sleep(5);
			
			 boolean atRightBorder = cir.getLayoutX() >= maxX;
             boolean atLeftBorder = cir.getLayoutX() <= minX;
             boolean atBottomBorder = cir.getLayoutY() >= maxY;
             boolean atTopBorder = cir.getLayoutY() <= minY;
			 
			 if (atRightBorder || atLeftBorder) {
				 x*=-1;
             }
             if (atBottomBorder || atTopBorder) {
				 y*=-1;
			}
			
			for (int j = 0; j < i; j++) {
			if (cir.getLayoutX() <= r[j].getLayoutX() + bounds2.getMaxX()
					   && cir.getLayoutX() >= r[j].getLayoutX()
				   && cir.getLayoutY() == (int)r[j].getLayoutY() && playerID[j] == playerIDnow
				   || cir.getLayoutX() <= r[j].getLayoutX() + bounds2.getMaxX()
					   && cir.getLayoutX() >= r[j].getLayoutX()
				   && cir.getLayoutY() == (int)r[j].getLayoutY() + bounds2.getMaxY() && playerID[j] == playerIDnow) {
					 y *=-1;
				   }
			if (cir.getLayoutY() <= r[j].getLayoutY() + bounds2.getMaxY()
					   && cir.getLayoutY() >= r[j].getLayoutY()
				   && cir.getLayoutX() == (int)r[j].getLayoutX() + bounds2.getMaxX() && playerID[j] == playerIDnow
				   || cir.getLayoutY() <= r[j].getLayoutY() + bounds2.getMaxY()
					   && cir.getLayoutY() >= r[j].getLayoutY()
				   && cir.getLayoutX() == (int)r[j].getLayoutX() && playerID[j] == playerIDnow) {
					  x *=-1;
			} 
			}
			
			} catch (Exception e) { System.out.println("Error:\t" + e); }
		}
	}
	
	public double getX() {
		return cir.getLayoutX();
	}
	
	public double getY() {
		return cir.getLayoutY();
	}
	
	public void setRecX(double x) {
		for (int j = 0; j <= i; j++) {
			if (playerID[j] == playerIDnow) { r[j].setLayoutX(x); }
		}
	}
	
	public void setRecY(double y) {
		for (int j = 0; j <= i; j++) {
			if (playerID[j] == playerIDnow) { r[j].setLayoutY(y); }
		}
	}
	
	public void setPlayerID(int playerIDnow) {
		this.playerIDnow = playerIDnow;
	}
	public void createRec(int playerID) {
		this.playerID[i] = playerID;
		r[i] = new Rectangle(100, 200);

		i++;
	}
	
	public void setKey(boolean key) {
		this.key = key;
	}
}


class Thread_snet extends Thread {
	AnimB ab;
	int playerID = 100;
	int countPlayers = 1;
	Server[] s = new Server[4];
	int i = 0;
	
	public Thread_snet(AnimB ab) {	
		this.ab = ab;
	}

	@Override
	public void run() {
		Socket clientConnection = null;
		ServerSocket serverConnection = null;
		System.out.println("Server Listening......");
		try{
			serverConnection = new ServerSocket(1111); // can also use static final PORT_NUM , when defined
	
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Server error");
		}

		while(true){
			try{
				clientConnection = serverConnection.accept();
				System.out.println("connection Established");
				ab.createRec(playerID);
				ab.setKey(true);
				s[i] = new Server(clientConnection, ab, playerID);
				for (int j = 0; j <= i; j++) {
					s[j].setCountPlayers(countPlayers++);
				}
				s[i].start();
				playerID++;
				i++;
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println("Connection Error");
			}
		}
	}
}


class Server extends Thread
{
	Socket clientConnection = null;
	AnimB ab;
	int playerID;
	int playerIDclient;
	int countPlayers;
	
	static double x = 1.0;
	static double y = 1.0;
	
	public Server(Socket cc, AnimB ab, int playerID) {
		clientConnection = cc;
		this.ab = ab;
		this.playerID = playerID;
		this.countPlayers = countPlayers;
	}
	public void setCountPlayers(int countPlayers) {
		this.countPlayers = countPlayers;
	}
	
	
	@Override
	public void run()
	{
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		try
		{	
		out = new ObjectOutputStream(clientConnection.getOutputStream());
		in = new ObjectInputStream(clientConnection.getInputStream());
		
		out.writeObject(playerID);
			while(true) {
				out.writeObject(countPlayers);
				Object obj = in.readObject();
				playerIDclient = (int)obj;
				ab.setPlayerID(playerIDclient);
				
				obj = in.readObject();
				double value = (double)obj;
				ab.setRecX(value);
				obj = in.readObject();
				double value2 = (double)obj;
				ab.setRecY(value2);
				
				x = ab.getX();
				y = ab.getY();
				//System.out.println("X:\t" + x);
				//System.out.println("Y:\t" + y);
				System.out.println();
				out.writeObject(x);
				out.writeObject(y);
				
				out.writeObject(value);
				out.writeObject(value2);

			}

		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);	
		}
	}
}
	
	
	

