package dbObjects;

public class Hotelarz
{
    public int ID;
    public String email;
    public String haslo;
    public String imie;
    public String nazwisko;
    public String dataUrodzenia;

    Hotelarz(int ID, String email, String haslo, String imie, String nazwisko, String dataUrodzenia)
    {
        this.ID = ID;
        this.email = email;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
    }
}

