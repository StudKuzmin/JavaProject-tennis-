
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;




public class MainScene {
	private FlowPane mainRoot;
	private BorderPane playRoot;
	private int i = 0;
	private Scene scene;
	private Rectangle[] rec = new Rectangle[4];
	private int[] playerID = new int[4];
	private int counterID = 100;
	
	public void init(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		mainRoot.setFocusTraversable(true);
        mainRoot.requestFocus();
		
		BorderPane.setAlignment(v.getBack(), Pos.BOTTOM_RIGHT);
		
		playRoot = new BorderPane();
		playRoot.setBottom(v.getBack());
		playRoot.setBackground(v.getBackground());
		playRoot.getChildren().add(v.getCircle());
		playRoot.getChildren().add(v.getRectangle());
		
		scene = new Scene(mainRoot);
	}
	
	
	
	public FlowPane getMainRoot() {
		return mainRoot;
	}
	public BorderPane getPlayRoot() {
		return playRoot;
	}
	public void setRec() {
		rec[i] = new Rectangle(100, 200);
		mainRoot.getChildren().add(rec[i]);
		playerID[i++] = counterID++;
	}
	public Scene getScene() {
		return scene;
	}
	
	public void setRecXY(double recx, double recy, int playerID) {
		for(int j = 0; j < i; j++) {
			if (this.playerID[j] != playerID) {
				rec[j].setLayoutX(recx);
				rec[j].setLayoutY(recy);
			}
		}
	}
}