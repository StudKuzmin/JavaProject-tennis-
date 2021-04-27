import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane mainRoot;
	private FlowPane playRoot;
	
	private Scene scene;
	
	public MainScene() {
		
	}
	public MainScene(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		
		playRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getBack());
		playRoot.setAlignment(Pos.CENTER);
		
		scene = new Scene(mainRoot);
	}
	
	public FlowPane getMainRoot() {
		return mainRoot;
	}
	public FlowPane getPlayRoot() {
		return playRoot;
	}
	public Scene getScene() {
		return scene;
	}
}