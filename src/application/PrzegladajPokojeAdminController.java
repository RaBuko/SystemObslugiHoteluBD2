package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PrzegladajPokojeAdminController {
private LoginController loginCtrl;
	public DatabaseCommunication databaseCommunication;
	@FXML
	public void powrot(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuAdmin.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		MenuAdminController menuAdminCtrl = loader.getController();
		menuAdminCtrl.setLoginController(loginCtrl);
		menuAdminCtrl.databaseCommunication = databaseCommunication;
		
		loginCtrl.setScreen(pane);
	
	}
	
	public void dodajPokoj(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("DodajPokoj.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		DodajPokojController dodajPokojCtrl = loader.getController();
		dodajPokojCtrl.setLoginController(loginCtrl);
		dodajPokojCtrl.databaseCommunication =databaseCommunication;
		
		loginCtrl.setScreen(pane);
	}
	
	public void usunPokoj(){
		
	}
	
	public void edytujDane(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EdytujPokoj.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		EdytujPokojController edytujPokojCtrl = loader.getController();
		edytujPokojCtrl.setLoginController(loginCtrl);
		edytujPokojCtrl.databaseCommunication = databaseCommunication;
		
		loginCtrl.setScreen(pane);
	}
	
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
	
}
