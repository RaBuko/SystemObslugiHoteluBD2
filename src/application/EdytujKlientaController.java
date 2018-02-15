package application;

import dbObjects.Klient;
import dbconnector.DatabaseCommunication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class EdytujKlientaController {
    public TextField imieField;
    public TextField nazwiskoField;
    public TextField emailField;
    public TextField numerTelefonuField;
    public TextField rodzajDokumentuField;
    public TextField numerDokumentuField;
    public TextField jezykField;
    private LoginController loginCtrl;

	public Klient wybranyKlient;

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
	
	public void edytuj()
    {
        String [] arguments = {
                Integer.toString(wybranyKlient.getID()),
        imieField.getText(),
        nazwiskoField.getText(),
        numerTelefonuField.getText(),
        emailField.getText(),
        rodzajDokumentuField.getText(),
        numerDokumentuField.getText(),
        jezykField.getText()};
        databaseCommunication.updateClient(arguments);

        powrot();
	}
	
	public void setLoginController(LoginController loginCtrl)
    {
		this.loginCtrl = loginCtrl;
		imieField.setText(wybranyKlient.getImie());
		nazwiskoField.setText(wybranyKlient.getNazwisko());
		emailField.setText(wybranyKlient.getEmail());
		numerTelefonuField.setText(Long.toString(wybranyKlient.getNumerTelefonu()));
		rodzajDokumentuField.setText(wybranyKlient.getRodzajDokumentu());
		numerDokumentuField.setText(wybranyKlient.getNumerDokumentu());
		jezykField.setText(wybranyKlient.getJezyk());
	}
}
