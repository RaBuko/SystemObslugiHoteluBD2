package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;


public class Main extends Application{
	
	public static void on(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
    {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
			StackPane stackPane = loader.load();
			Scene scene = new Scene(stackPane,700,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("System obslugi hotelu");
			primaryStage.show();
	}
}
