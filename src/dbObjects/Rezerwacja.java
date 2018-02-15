package dbObjects;

public class Rezerwacja
{
    public int HotelarzID;
    public int PokojID;
    public int KlientID;
    public String dataPrzyjazdu;
    public String dataWyjazdu;
    public double rachunek;
    public double zaliczka;
    public int liczbaOsob;
    public boolean sniadanie;

    Rezerwacja(int hotelarzID, int pokojID, int klientID, String dataPrzyjazdu, String dataWyjazdu, double rachunek, double zaliczka, int liczbaOsob, boolean sniadanie)
    {
        this.HotelarzID = hotelarzID;
        this.PokojID = pokojID;
        this.KlientID = klientID;
        this.dataPrzyjazdu = dataPrzyjazdu;
        this.dataWyjazdu = dataWyjazdu;
        this.rachunek = rachunek;
        this.zaliczka = zaliczka;
        this.liczbaOsob = liczbaOsob;
        this.sniadanie = sniadanie;
    }
}
