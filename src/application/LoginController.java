//to jest MainController, pomieszane nazwy

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class LoginController {
	@FXML
	private StackPane mainStackPane;
	
	@FXML
	public void initialize(){
		loadLogowanieScreen();
	}
	
	public void loadLogowanieScreen()
    {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Logowanie.fxml"));
		Pane pane = null;
		try
		{
			pane = loader.load();
		}
		catch(IOException e)
        {
			e.printStackTrace();
		}
	LogowanieController logowanieController = loader.getController();
	logowanieController.setLoginController(this);
	setScreen(pane);
	}

	public void setScreen(Pane pane) {
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
}
