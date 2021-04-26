import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane mainRoot;
	private FlowPane playRoot;
	
	private Scene menuScene;
	private Scene playScene;
	
	public MainScene() {
		
	}
	public MainScene(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		
		playRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getBack());
		playRoot.setAlignment(Pos.CENTER);
		
		menuScene = new Scene(mainRoot);
		playScene = new Scene(playRoot);
	}
	
	// public void addPanel(FlowPane root) {
		// scene = new Scene(root);		
	// }
	
	public Scene getMenuScene() {
		return menuScene;
	}
	public Scene getPlayScene() {
		return playScene;
	}
	
}