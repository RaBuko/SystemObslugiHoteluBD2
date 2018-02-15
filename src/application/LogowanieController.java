package application;

import com.sun.tools.javac.Main;
import dbconnector.DatabaseCommunication;
import dbconnector.DatabaseConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LogowanieController {


    private LoginController loginCtrl;
    public DatabaseCommunication databaseCommunication;

	@FXML private PasswordField passwordField;
	@FXML private TextField loginField;
    @FXML public Label labelInfo;

    FXMLLoader loader;

	public void zaloguj()
    {
        databaseCommunication = new DatabaseCommunication(true);
        int result = databaseCommunication.checkLogin(loginField.getText(),passwordField.getText());
        if (result == 1)
        {
            String [] workersData = databaseCommunication.getWorkerData();
            databaseCommunication.dbConnector.disconnectFromDatabase();
            databaseCommunication = new DatabaseCommunication(false);
            databaseCommunication.setWorkerData(Integer.parseInt(workersData[0]), workersData[1], workersData[2], workersData[3]);
            loader = new FXMLLoader(this.getClass().getResource("MenuHotelarz.fxml"));
        }
        else if (result == 2)
        {
            loader = new FXMLLoader(this.getClass().getResource("MenuAdmin.fxml"));
        }
        else
        {
            databaseCommunication.dbConnector.disconnectFromDatabase();
            labelInfo.setText("Nie udalo sie zalogowac, prosze sprobowac jeszcze raz");
            return;
        }

		Pane pane = null;
		try{
			pane = loader.load();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		if (result == 2) {
            MenuAdminController menuAdminCtrl = loader.getController();
            menuAdminCtrl.databaseCommunication = databaseCommunication;
            menuAdminCtrl.setLoginController(loginCtrl);
        }

		if (result == 1) {
            MenuHotelarzController menuHotelarzCtrl = loader.getController();
            menuHotelarzCtrl.databaseCommunication = databaseCommunication;
            menuHotelarzCtrl.setLoginController(loginCtrl);
        }
		
		
		loginCtrl.setScreen(pane);
	}
	
	public void exit(){
		System.exit(0);
	
	}
	
	public void setLoginController(LoginController loginCtrl) {
		this.loginCtrl = loginCtrl;
	}
	
	
}
