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
	static private Pane root;
	
	
	
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        root = new Pane();
        Scene scene = new Scene(root, 800, 600);


		stage.setMaximized(true);
        stage.setTitle("Server");
        stage.setScene(scene);
		
		stage.show();
		
		cir = new Circle();
		cir = new Circle(15, Color.BLUE);
		cir.relocate(100, 100);

		Rectangle rec = new Rectangle(100, 200);


		// Чтобы могли управлять мячом
        root.setFocusTraversable(true);
        root.requestFocus();
		
		root.getChildren().addAll(cir, rec);
		
		Bounds bounds = root.getBoundsInLocal();
		
		Server s = new Server();
		Thread_ball t = new Thread_ball(cir, bounds, s, rec);
		t.start();
		
		
    }
}




class Server
{
	static private ServerSocket serverConnection;
	static private Socket clientConnection;
	static private ObjectOutputStream out;
	static private ObjectInputStream in;
	
	static double x = 1.0;
	static double y = 1.0;
	
	
	public static void st(AnimB ab_)
	{
		AnimB ab = ab_;
		Rectangle rec = new Rectangle(100, 200);
		
		
		
		try
		{	
			serverConnection = new ServerSocket(1111, 10);
			clientConnection = serverConnection.accept();
			while(true) {
				out = new ObjectOutputStream(clientConnection.getOutputStream());
			    in = new ObjectInputStream(clientConnection.getInputStream());
				
				
				Object obj = in.readObject();
				double value = (double)obj;
				ab.setRecX(value);
				
				obj = in.readObject();
				double value2 = (double)obj;
				ab.setRecY(value2);
				
				x = ab.getX();
				y = ab.getY();
				System.out.println("X:\t" + x);
				System.out.println("Y:\t" + y);
				System.out.println();
				sendData();
			}

		}
		catch (Exception e)
		{
			System.out.println("Error: " + e);	
		}
	}
	private static void sendData(){
		try {
			out.writeObject(x);
			out.writeObject(y);
			
		} catch (Exception e) { System.out.println("Error: " + e); }
	}
}
	
	
	
	
	
	
	
class Thread_snet extends Thread {
	
	private Server s;
	static private Pane root;
	
	AnimB ab;
	
	public Thread_snet(Server s, AnimB ab) {
		this.s = s;
		this.ab = ab;
	}
	
	@Override
	public void run() {
		s.st(ab);
	}
}


class Thread_ball extends Thread {
	Server s;
	
	AnimB an;

	
	public Thread_ball(Circle cir, Bounds bounds, Server s, Rectangle rec) {	
		this.s = s;
		an = new AnimB(cir, bounds, s, rec);
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
	
	Server s;
	
	Rectangle rec;
	
	Bounds bounds2;
	
	public AnimB() {
		
	}
	
	public AnimB(Circle cir, Bounds bounds, Server s, Rectangle rec) {
		this.cir = cir;
		this.rec = rec;
		bounds2 = rec.getBoundsInLocal();
		
		this.maxX = bounds.getMaxX();
		this.maxY = bounds.getMaxY();
		this.minX = bounds.getMinX();
		this.minY = bounds.getMinY();
		
		this.s = s;
	}

	public void st() {
		Thread_snet ts = new Thread_snet(s, this);
		ts.start();
		
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
			
			
			if (cir.getLayoutX() <= rec.getLayoutX() + bounds2.getMaxX()
					   && cir.getLayoutX() >= rec.getLayoutX()
				   && cir.getLayoutY() == (int)rec.getLayoutY()
				   || cir.getLayoutX() <= rec.getLayoutX() + bounds2.getMaxX()
					   && cir.getLayoutX() >= rec.getLayoutX()
				   && cir.getLayoutY() == (int)rec.getLayoutY() + bounds2.getMaxY()) {
					 y *=-1;
				   }
				   if (cir.getLayoutY() <= rec.getLayoutY() + bounds2.getMaxY()
					   && cir.getLayoutY() >= rec.getLayoutY()
				   && cir.getLayoutX() == (int)rec.getLayoutX() + bounds2.getMaxX()
				   || cir.getLayoutY() <= rec.getLayoutY() + bounds2.getMaxY()
					   && cir.getLayoutY() >= rec.getLayoutY()
				   && cir.getLayoutX() == (int)rec.getLayoutX()) {
					  x *=-1;
			} } catch (Exception e) { System.out.println("Error:\t" + e); }
		}
	}
	
	public double getX() {
		return cir.getLayoutX();
	}
	
	public double getY() {
		return cir.getLayoutY();
	}
	
	public void setRecX(double x) {
		rec.setLayoutX(x);
	}
	
	public void setRecY(double y) {
		rec.setLayoutY(y);
	}
	
}