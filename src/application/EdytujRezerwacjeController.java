package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class EdytujRezerwacjeController
{
	private LoginController loginCtrl;

	public DatabaseCommunication databaseCommunication;
	@FXML
	public void powrot()
    {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajRezerwacje.fxml"));
		Pane pane = null;
		try
        {
			pane = loader.load();
		}
		catch(IOException e)
        {
			e.printStackTrace();
		}
		PrzegladajRezerwacjeController przegladajRezerwacjeCtrl = loader.getController();
		przegladajRezerwacjeCtrl.setLoginController(loginCtrl);
		przegladajRezerwacjeCtrl.databaseCommunication = databaseCommunication;
		
		loginCtrl.setScreen(pane);
	}
	
	public void edytuj(){
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
}
