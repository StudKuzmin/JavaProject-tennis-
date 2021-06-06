import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class MainScene {
	private BorderPane mainRoot;
	private BorderPane playRoot;
	
	private Scene scene;
	
	public void init(View v, Rectangle rec) {
		mainRoot = new BorderPane();
		mainRoot.getChildren().addAll(v.getPlay(), v.getSettings(), v.getExit(), rec);
		// mainRoot.setAlignment(Pos.CENTER);
		
		// // Сначала позицию для кнопки
		// BorderPane.setAlignment(v.getBack(), Pos.BOTTOM_RIGHT);
		// BorderPane.setAlignment(rec, Pos.CENTER);
		// // Потом саму кнопку
		// playRoot = new BorderPane(rec);
		// playRoot.setBottom(v.getBack());
		// playRoot.setBackground(v.getBackground());
		
		scene = new Scene(mainRoot);
	}
	
	
	
	public BorderPane getMainRoot() {
		return mainRoot;
	}
	public BorderPane getPlayRoot() {
		return playRoot;
	}
	public Scene getScene() {
		return scene;
	}
}