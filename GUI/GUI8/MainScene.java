import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane root;
	Scene scene;
		
	public MainScene(Controller c) {
		root = new FlowPane(Orientation.VERTICAL, 10, 10, c.getPlay(), c.getSettings(), c.getExit());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
}