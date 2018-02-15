package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PrzegladajRezerwacjeController {
private LoginController loginCtrl;
	public DatabaseCommunication databaseCommunication;
	@FXML
	public void powrot() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuHotelarz.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		MenuHotelarzController menuHotelarzCtrl = loader.getController();
		menuHotelarzCtrl.setLoginController(loginCtrl);
		menuHotelarzCtrl.databaseCommunication = databaseCommunication;
		loginCtrl.setScreen(pane);
	
	}
	
	public void dodajRezerwacje(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("DodajRezerwacje.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		DodajRezerwacjeController dodajRezerwacjeCtrl = loader.getController();
		dodajRezerwacjeCtrl.setLoginController(loginCtrl);
		dodajRezerwacjeCtrl.databaseCommunication = databaseCommunication;
		loginCtrl.setScreen(pane);
	}
	
	public void usunRezerwacje(){
		
	}
	
	public void edytujDane(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EdytujRezerwacje.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		EdytujRezerwacjeController edytujRezerwacjeCtrl = loader.getController();
		edytujRezerwacjeCtrl.setLoginController(loginCtrl);
		edytujRezerwacjeCtrl.databaseCommunication = databaseCommunication;
		
		loginCtrl.setScreen(pane);
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
	
}
