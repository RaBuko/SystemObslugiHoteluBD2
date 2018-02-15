package application;

import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuHotelarzController {

    public Label ImieNazwiskoEmailLabel;
    private LoginController loginCtrl;
	public DatabaseCommunication databaseCommunication;
	@FXML
	public void wyloguj(){
		loginCtrl.loadLogowanieScreen();
	}
	
	public void zmienHaslo(){
		
	}
	
	public void przegladajKlientow(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajKlientow.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		PrzegladajKlientowController przegladajKlientowCtrl = loader.getController();
		przegladajKlientowCtrl.databaseCommunication =databaseCommunication;
		przegladajKlientowCtrl.setLoginController(loginCtrl);
		przegladajKlientowCtrl.showClients();

		loginCtrl.setScreen(pane);
	}
	
	public void przegladajPokoje(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajPokojeHotelarz.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		PrzegladajPokojeHotelarzController przegladajPokojeHotelarzCtrl = loader.getController();
		przegladajPokojeHotelarzCtrl.setLoginController(loginCtrl);
        przegladajPokojeHotelarzCtrl.databaseCommunication = databaseCommunication;
		
		loginCtrl.setScreen(pane);
	}
	
	public void przegladajRezerwacje(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajRezerwacje.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		PrzegladajRezerwacjeController przegladajRezerwacjeCtrl = loader.getController();
		przegladajRezerwacjeCtrl.setLoginController(loginCtrl);
        przegladajRezerwacjeCtrl.databaseCommunication = databaseCommunication;
		loginCtrl.setScreen(pane);
	}
	
	public void setLoginController(LoginController loginCtrl)
    {
        String [] data = databaseCommunication.getWorkerData();
        this.ImieNazwiskoEmailLabel.setText("Zalogowano jako: " + data[1] + " " + data[2] + " (" + data[3] + ") " + "[" + data[0] +"]");
		this.loginCtrl = loginCtrl;
	}
}
