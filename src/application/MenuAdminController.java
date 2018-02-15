package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuAdminController
{
	public Label adminZalogowanoLabel;
	private LoginController loginCtrl;
	public DatabaseCommunication databaseCommunication;

	@FXML
	public void wyloguj(){
		loginCtrl.loadLogowanieScreen();
	}
	
	public void zmienHaslo()
	{
		
	}
	
	public void przegladajPracownikow(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajPracownikow.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}

		PrzegladajPracownikowController przegladajPracownikowCtrl = loader.getController();
		przegladajPracownikowCtrl.databaseCommunication = databaseCommunication;
		przegladajPracownikowCtrl.setLoginController(loginCtrl);
		
		
		loginCtrl.setScreen(pane);
	}
	
	public void przegladajPokoje()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajPokojeAdmin.fxml"));
		Pane pane = null;
		try
		{
			pane = loader.load();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		PrzegladajPokojeAdminController przegladajPokojeAdminCtrl = loader.getController();
		przegladajPokojeAdminCtrl.databaseCommunication = databaseCommunication;
		przegladajPokojeAdminCtrl.setLoginController(loginCtrl);
		
		
		loginCtrl.setScreen(pane);
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.adminZalogowanoLabel.setText("Zalogowano jako: " + databaseCommunication.workersEmail + " (ADMIN)");
		this.loginCtrl = loginCtrl;
	}
	
}
