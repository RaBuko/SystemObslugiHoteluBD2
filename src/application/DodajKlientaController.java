package application;

import dbObjects.Klient;
import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DodajKlientaController
{
    public TextField imieField;
    public TextField nazwiskoField;
    public TextField emailField;
    public TextField numerTelefonuField;
    public TextField numerDokumentuField;
    public TextField rodzajDokumentuField;
    public TextField jezykField;

    private LoginController loginCtrl;

	public DatabaseCommunication databaseCommunication;

	@FXML
	public void powrot(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PrzegladajKlientow.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		PrzegladajKlientowController przegladajKlientowCtrl = loader.getController();
		przegladajKlientowCtrl.databaseCommunication = databaseCommunication;
		przegladajKlientowCtrl.setLoginController(loginCtrl);
		przegladajKlientowCtrl.showClients();
		loginCtrl.setScreen(pane);
	}
	
	public void dodaj()
	{
	    if (imieField.getText().equals("") ||
                nazwiskoField.getText().equals("") ||
                numerDokumentuField.getText().equals("") ||
                rodzajDokumentuField.getText().equals(""))
	        return;

	    if (emailField.getText().equals("") && numerTelefonuField.getText().equals(""))
	        return;

	    if (numerTelefonuField.getText().equals(""))
	        numerTelefonuField.setText("0");
	    if (jezykField.getText().equals(""))
	    	jezykField.setText("NULL");

	    String [] arguments = {Integer.toString(databaseCommunication.workerID),
                imieField.getText(),
                nazwiskoField.getText(),
                numerTelefonuField.getText(),
                emailField.getText(),
                rodzajDokumentuField.getText(),
                numerDokumentuField.getText(),
                jezykField.getText()};
	    databaseCommunication.insertClient(arguments);
        powrot();
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
}
