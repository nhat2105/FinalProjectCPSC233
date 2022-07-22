package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			int WIDTH = 600;
			int HEIGHT = 400;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, WIDTH, HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CPSC233 Final Project");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
