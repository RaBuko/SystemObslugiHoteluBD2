package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DodajPokojController {
private LoginController loginCtrl;

	public DatabaseCommunication databaseCommunication;
	@FXML
	public void powrot(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajPokojeAdmin.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		PrzegladajPokojeAdminController przegladajPokojeAdminCtrl = loader.getController();
		przegladajPokojeAdminCtrl.setLoginController(loginCtrl);
		przegladajPokojeAdminCtrl.databaseCommunication =databaseCommunication;
		
		loginCtrl.setScreen(pane);
	
	}
	
	public void dodaj(){
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
}
