import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.Scene;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.stage.Stage;

public class View extends Controller {
	private Button play;		
	private Button settings;
	private Button exit;	
	private Button back;

	
	private Image imgTennis;
	private ImageView imgT;
	private Image imgPlay;
	private ImageView imgP;
	private Image imgSettings;
	private ImageView imgS;
	private Image imgExit;
	private ImageView imgE;
	private Image imgField;
	private ImageView imgF;
	
	private BorderPane Bp;
	private Model m;
	private String str;
	
	private BackgroundSize backgroundSize;
	private BackgroundImage background_image;
	private Background background;
	
	MainScene ms;
	Stage stage;
	
	public View(){}
	public View(MainScene ms, Stage stage){
		m = new Model();
		this.ms = ms;
		this.stage = stage;
		
		imgTennis = new Image("./Images/Tennis.png");
		imgT = new ImageView(imgTennis);
		imgPlay = new Image("./Images/Play.png", 50, 50, true, true);
		imgP = new ImageView(imgPlay);
		imgSettings = new Image("./Images/Settings.png", 70, 70, true, true);
		imgS = new ImageView(imgSettings);
		imgExit = new Image("./Images/Exit.png", 50, 50, true, true);
		imgE = new ImageView(imgExit);
		imgField = new Image("./Images/Field.jpg");
		imgF = new ImageView(imgField);
		
		
		play = new Button("Play!", /*Bp*/ imgP);	
		settings = new Button("Settings", imgS);
		exit = new Button("Exit", imgE); 
		back = new Button("Back");
		
		
		play.setPrefSize(300, 80);
		settings.setPrefSize(300, 80);
		exit.setPrefSize(300, 80);
		back.setPrefSize(300, 80);
		
		// double width, double height, 
		// boolean widthAsPercentage, boolean heightAsPercentage, 
		// boolean contain, boolean cover
		// Ширина, высота,
		// Ширина в процентах, Высота в процентах,
		// Содержание, Покрытие
		backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
		// Image image, BackgroundRepeat repeatX, 
		// BackgroundRepeat repeatY, BackgroundPosition position, BackgroundSize size
		// Картинка, повторение изображений, 
		// повторение изображений, позиция картинки, размер картинки
		background_image = new BackgroundImage(imgField, BackgroundRepeat.NO_REPEAT, 
		BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,  backgroundSize);
		
		background = new Background(background_image);
		
		ms.init(this);
		
	}
	
	private void pressBack() {
		back.setOnAction(event -> {
			stage.getScene().setRoot(ms.getMainRoot());
		});
	}
	
	public void pressPlay(){
		pressPlay_Controller(m);
		
		play.setOnAction(event -> {
			play.setText(m.getPlay());
			stage.getScene().setRoot(ms.getPlayRoot());
			pressBack();
		});
	}
	public void pressSettings(){
		pressSettings_Controller(m);
		
		settings.setOnAction(event -> {
			settings.setText(m.getSettings());

		});
	}
	public void pressExit(){
		pressExit_Controller(m);
		
		exit.setOnAction(event -> {
			exit.setText(m.getExit());
			stage.close();
		});
	}
	
	
	public Button getPlay(){
		return play;
	}
	public Button getSettings(){
		return settings;
	}
	public Button getExit(){
		return exit;
	}
	
	public Button getBack(){
		return back;
	}
	
	public Background getBackground(){
		return background;
	}
	
}