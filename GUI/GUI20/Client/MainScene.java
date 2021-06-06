import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private FlowPane mainRoot;
	private BorderPane playRoot;
	private Pane paneRoot;
	
	private Scene scene;
	
	public void init(View v) {
		mainRoot = new FlowPane(Orientation.VERTICAL, 10, 10, v.getPlay(), v.getSettings(), v.getExit());
		mainRoot.setAlignment(Pos.CENTER);
		mainRoot.setFocusTraversable(true);
        mainRoot.requestFocus();
		

		// Сначала позицию для кнопки
		BorderPane.setAlignment(v.getBack(), Pos.BOTTOM_RIGHT);
		// Потом саму кнопку
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
	public Scene getScene() {
		return scene;
	}
	// public Pane getPlayRoot() {
		// return paneRoot;
	// }
}