package application;

import dbObjects.Klient;
import dbconnector.DatabaseCommunication;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.IOException;

public class PrzegladajKlientowController
{
    public TableColumn idColumn;
    public TableColumn hotelarzIdColumn;
    public TableColumn imieColumn;
    public TableColumn nazwiskoColumn;
    public TableColumn telefonColumn;
    public TableColumn emailColumn;
    public TableColumn rodzajdokumentuColumn;
    public TableColumn numerdokumentuColumn;
    public TableColumn jezykColumn;

    public TableView<Klient> clientsTable;

    DatabaseCommunication databaseCommunication;
    private LoginController loginCtrl;
    Klient wybranyKlient;

	@FXML
	public void powrot(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuHotelarz.fxml"));
		Pane pane = null;
		try
		{
			pane = loader.load();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		MenuHotelarzController menuHotelarzCtrl = loader.getController();
		menuHotelarzCtrl.databaseCommunication = databaseCommunication;
		menuHotelarzCtrl.setLoginController(loginCtrl);
		loginCtrl.setScreen(pane);
	}
	
	public void dodajKlienta(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("DodajKlienta.fxml"));
		Pane pane = null;
		try{
			pane = loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		DodajKlientaController dodajKlientaCtrl = loader.getController();
		dodajKlientaCtrl.databaseCommunication = databaseCommunication;
		dodajKlientaCtrl.setLoginController(loginCtrl);
		loginCtrl.setScreen(pane);
	}
	
	public void usunKlienta()
    {
        if (wybranyKlient != null)
        {
            databaseCommunication.deleteClient(wybranyKlient);
            showClients();
            wybranyKlient = null;
        }
	}

	public void showClients()
    {
        clientsTable.setRowFactory(new Callback<TableView<Klient>, TableRow<Klient>>() {
            @Override
            public TableRow<Klient> call(TableView<Klient> param) {
                final TableRow<Klient> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        wybranyKlient = row.getItem();
                    }
                });

                return row;
            }
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<Klient, Integer>("ID"));
        hotelarzIdColumn.setCellValueFactory(new PropertyValueFactory<Klient, Integer>("HotelarzID"));
        imieColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("imie"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("nazwisko"));
        telefonColumn.setCellValueFactory(new PropertyValueFactory<Klient, Long>("numerTelefonu"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("email"));
        rodzajdokumentuColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("rodzajDokumentu"));
        numerdokumentuColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("numerDokumentu"));
        jezykColumn.setCellValueFactory(new PropertyValueFactory<Klient, String>("jezyk"));


        ObservableList<Klient> klients = getKlients();
        clientsTable.setItems(klients);
    }

	public void edytujDane()
    {
        if (wybranyKlient != null) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EdytujKlienta.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            EdytujKlientaController edytujKlientaCtrl = loader.getController();
            edytujKlientaCtrl.databaseCommunication = databaseCommunication;
            edytujKlientaCtrl.wybranyKlient = wybranyKlient;
            edytujKlientaCtrl.setLoginController(loginCtrl);
            loginCtrl.setScreen(pane);
            wybranyKlient = null;
        }
	}
	
	public void setLoginController(LoginController loginCtrl)
    {
        this.loginCtrl = loginCtrl;
	}

    private ObservableList<Klient> getKlients()
    {
        ObservableList<Klient> klients = FXCollections.observableArrayList();
        String data = databaseCommunication.selectAllClients();
        
        String [] rows = data.split("\n");
        for (String row: rows)
        {
            String [] elems = row.split(";");
            klients.add(new Klient(Integer.parseInt(elems[0]),
                    Integer.parseInt(elems[1]),
                    elems[2],
                    elems[3],
                    Long.parseLong(elems[4]),
                    elems[5],
                    elems[6],
                    elems[7],
                    elems[8]));
        }
        return klients;
    }
}
