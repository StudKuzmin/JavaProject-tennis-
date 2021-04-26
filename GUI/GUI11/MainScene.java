import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane root;
	Scene scene;
		
	public MainScene(View v) {
		root = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root);
	}
	
	public Scene getScene() {
		return scene;
	}
}