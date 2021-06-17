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

		stage.setMaximized(true);
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
		
		Bounds boundsScreen = root.getBoundsInLocal();
		
		Thread_ball t = new Thread_ball(cir, boundsScreen);
		t.start();
		
		
    }
}

class Thread_ball extends Thread {	
	AnimationBall ab;

	public Thread_ball(Circle cir, Bounds boundsScreen) {	
		ab = new AnimationBall(cir, boundsScreen);
	}

	@Override
	public void run() {
		ab.st();
	}
}


class AnimationBall {
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
	
	Bounds boundsRec;
	
	int i = 0;
	int[] playerID;
	int playerIDnow;

	int score1 = 0;
	int score2 = 0;
	
	public AnimationBall(Circle cir, Bounds boundsScreen) {
		this.cir = cir;
		
		rec = new Rectangle(100,200);
		r = new Rectangle[4];
		playerID = new int[4];
		boundsRec = rec.getBoundsInLocal();
		
	
		
		this.maxX = boundsScreen.getMaxX();
		this.maxY = boundsScreen.getMaxY();
		this.minX = boundsScreen.getMinX();
		this.minY = boundsScreen.getMinY();
	}

	public void st() {
		Thread_Clients_Connection ts = new Thread_Clients_Connection(this);
		ts.start();
		
		while(key == false) {  try { Thread.sleep(1000); } catch (Exception e) {} System.out.println("Waiting for players..."); }
		while(true) {
			try {
			cir.setLayoutX(cir.getLayoutX() + x);
			cir.setLayoutY(cir.getLayoutY() + y);
			 
			Thread.sleep(5);
			
			boolean atRightBorder = cir.getLayoutX() >= maxX;
            boolean atLeftBorder = cir.getLayoutX() <= minX;
            boolean atBottomBorder = cir.getLayoutY() >= maxY;
            boolean atTopBorder = cir.getLayoutY() <= minY;
			 
			if (atLeftBorder) {
				 x*=-1;
				 score2++;
            }
			if (atRightBorder) {
				 x*=-1;
				 score1++;
            }
             if (atBottomBorder || atTopBorder) {
				 y*=-1;
			}
			
			for (int j = 0; j < i; j++) {
			if (cir.getLayoutX() <= r[j].getLayoutX() + boundsRec.getMaxX()
					   && cir.getLayoutX() >= r[j].getLayoutX()
				   && cir.getLayoutY() == (int)r[j].getLayoutY() && playerID[j] == playerIDnow
				   || cir.getLayoutX() <= r[j].getLayoutX() + boundsRec.getMaxX()
					   && cir.getLayoutX() >= r[j].getLayoutX()
				   && cir.getLayoutY() == (int)r[j].getLayoutY() + boundsRec.getMaxY() && playerID[j] == playerIDnow) {
					 y *=-1;
				   }
			if (cir.getLayoutY() <= r[j].getLayoutY() + boundsRec.getMaxY()
					   && cir.getLayoutY() >= r[j].getLayoutY()
				   && cir.getLayoutX() == (int)r[j].getLayoutX() + boundsRec.getMaxX() && playerID[j] == playerIDnow
				   || cir.getLayoutY() <= r[j].getLayoutY() + boundsRec.getMaxY()
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
	
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
}


class Thread_Clients_Connection extends Thread {
	AnimationBall ab;
	int playerID = 100;
	int countPlayers = 1;
	Server[] s = new Server[4];
	int i = 0;
	CoordXY cr = new CoordXY();
	
	public Thread_Clients_Connection(AnimationBall ab) {	
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

		cr.start();
		while(true){
			try{
				clientConnection = serverConnection.accept();
				System.out.println("connection Established");
				ab.createRec(playerID);
				ab.setKey(true);
				s[i] = new Server(clientConnection, ab, playerID);
				for (int j = 0; j <= i; j++) {
					s[j].setCountPlayers(countPlayers);
				}
				s[i].start();
				cr.addS(s[i]);
			if (countPlayers >= 2) { cr.setKey(true); }
				playerID++;
				i++;
				countPlayers++;
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println("Connection Error");
			}
		}
	}
}

class CoordXY extends Thread {
	double recX, recY = 0;
	Server[] s = new Server[4];
	int i = 0;
	boolean key = false;
	int countPlayers = 0;
	
	@Override
	public void run() {
		while(key == false ) { try { Thread.sleep(1000); } catch (Exception e) {} System.out.println(""); }
		while (true) {
			try {
			s[0].setOtherXY(s[1].getRecX(), s[1].getRecY());
			s[1].setOtherXY(s[0].getRecX(), s[0].getRecY());
			System.out.println("");
			} catch (Exception e) { System.out.println("ERRROR: \t" + e); }
		}
	}
	
	public void addS(Server s) {
		this.s[i++] = s;
	}
	
	public void setKey(boolean key) {
		this.key = key;
	}
}

class Server extends Thread
{
	Socket clientConnection = null;
	AnimationBall ab;
	int playerID;
	int playerIDclient;
	int countPlayers;
	
	double recX, recY = 0;
	double otherX, otherY = 0;
	
	static double x = 1.0;
	static double y = 1.0;
	
	int score1 = 0;
	int score2 = 0;
	
	public Server(Socket cc, AnimationBall ab, int playerID) {
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
		
		// Отправляем ID нового игрока
		out.writeObject(playerID);
			while(true) {
				// Отправлем количество подключившихся игроков
				out.writeObject(countPlayers);
				
				// Принимаем ID текущего игрока клиента
				Object obj = in.readObject();
				playerIDclient = (int)obj;
				ab.setPlayerID(playerIDclient);
				
				// Принимаем координаты ракетки текущего игрока
				obj = in.readObject();
				recX = (double)obj;
				ab.setRecX(recX);
				obj = in.readObject();
				recY = (double)obj;
				ab.setRecY(recY);
				
				// Отправляем координаты ракетки другого игрока
				out.writeObject(otherX);
				out.writeObject(otherY);
				
				// Отправляем координаты шара
				x = ab.getX();
				y = ab.getY();
				//System.out.println("X:\t" + x);
				//System.out.println("Y:\t" + y);
				System.out.println();
				out.writeObject(x);
				out.writeObject(y);
				
				// Отправляем score
				out.writeObject(ab.getScore1());
				out.writeObject(ab.getScore2());
				

			}

		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);	
		}
	}
	
	public double getRecX() {
		return recX;
	}
	public double getRecY() {
		return recY;
	}
	
	public void setOtherXY(double otherX, double otherY) {
		this.otherX = otherX;
		this.otherY = otherY;
	}
	
	public void setScore12(int score1, int score2) {
		this.score1 = score1;
		this.score2 = score2;
	}
}
	
	
	

