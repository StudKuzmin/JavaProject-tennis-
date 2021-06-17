import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane mainRoot;
	private BorderPane playRoot;
	private int i = 0;
	private Scene scene;
	private Rectangle rec = new Rectangle(100, 200);
	
	private Label score1 = new Label("0");
	private Label score2 = new Label("0");
	
	private int sc1 = 0;
	private int sc2 = 0;
	
	public void init(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		mainRoot.setFocusTraversable(true);
        mainRoot.requestFocus();
		
		score1.setFont(new Font("Arial", 36));
		score2.setFont(new Font("Arial", 36));
		
		BorderPane.setAlignment(v.getBack(), Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(score1, Pos.TOP_LEFT);
		BorderPane.setAlignment(score2, Pos.TOP_RIGHT);
		
		playRoot = new BorderPane();
		playRoot.setBottom(v.getBack());
		playRoot.setBackground(v.getBackground());
		playRoot.getChildren().add(v.getCircle());
		playRoot.getChildren().add(v.getRectangle());
		playRoot.setLeft(score1);
		playRoot.setRight(score2);
		
		scene = new Scene(mainRoot);
	}
	
	
	
	public FlowPane getMainRoot() {
		return mainRoot;
	}
	public BorderPane getPlayRoot() {
		return playRoot;
	}
	public void setRec() {
		rec.setFill(Color.RED);
		playRoot.getChildren().add(rec);
	}
	public Scene getScene() {
		return scene;
	}
	
	public void setRecXY(double recx, double recy) {
		rec.setLayoutX(recx);
		rec.setLayoutY(recy);
	}
	
	public void changeTextScore1() {
		score1.setText(Integer.toString(sc1));
	}
	public void changeTextScore2() {
		score2.setText(Integer.toString(sc2));
	}
	
	public void setScore1(int score1) {
		sc1 = score1;
	}
	public void setScore2(int score2) {
		sc2 = score2;
	}
}