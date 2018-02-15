package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Klient {
    public SimpleIntegerProperty ID;
    public SimpleIntegerProperty HotelarzID;
    public SimpleStringProperty imie;
    public SimpleStringProperty nazwisko;
    public SimpleLongProperty numerTelefonu;
    public SimpleStringProperty email;
    public SimpleStringProperty rodzajDokumentu;
    public SimpleStringProperty numerDokumentu;
    public SimpleStringProperty jezyk;

    public Klient(int ID, int hotelarzID, String imie, String nazwisko, long numerTelefonu, String email, String rodzajDokumentu, String numerDokumentu, String jezyk)
    {
        this.ID = new SimpleIntegerProperty(ID);
        this.HotelarzID = new SimpleIntegerProperty(hotelarzID);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.numerTelefonu = new SimpleLongProperty(numerTelefonu);
        this.email = new SimpleStringProperty(email);
        this.rodzajDokumentu = new SimpleStringProperty(rodzajDokumentu);
        this.numerDokumentu = new SimpleStringProperty(numerDokumentu);
        this.jezyk = new SimpleStringProperty(jezyk);
    }

    public int getID() {
        return ID.get();
    }

    public int getHotelarzID() {
        return HotelarzID.get();
    }

    public String getImie() {
        return imie.get();
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public long getNumerTelefonu() {
        return numerTelefonu.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getRodzajDokumentu() {
        return rodzajDokumentu.get();
    }

    public String getNumerDokumentu() {
        return numerDokumentu.get();
    }

    public String getJezyk() {
        return jezyk.get();
    }
}
