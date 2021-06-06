import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane mainRoot;
	private BorderPane playRoot;
	
	private Scene scene;
	
	public void init(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		
		// Сначала позицию для кнопки
		BorderPane.setAlignment(v.getBack(), Pos.BOTTOM_RIGHT);
		BorderPane.setAlignment(v.getRectangle(), Pos.CENTER);
		// Потом саму кнопку
		playRoot = new BorderPane(v.getRectangle());
		playRoot.setBottom(v.getBack());
		playRoot.setBackground(v.getBackground());
		
		scene = new Scene(mainRoot);
	}
	
	
	
	public FlowPane getMainRoot() {
		return mainRoot;
	}
	public BorderPane getPlayRoot() {
		return playRoot;
	}
	public Scene getScene() {
		return scene;
	}
}