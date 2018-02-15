package dbObjects;

public class Pokoj
{
    int ID;
    int KlientID;
    int numerPokoju;
    int pietro;
    double poziomStandardu;
    int iloscOsob;
    double cenaZaDobe;

    Pokoj(int ID, int klientID, int numerPokoju, int pietro, double poziomStandardu, int iloscOsob, double cenaZaDobe)
    {
        this.ID = ID;
        this.KlientID = klientID;
        this.numerPokoju = numerPokoju;
        this.pietro = pietro;
        this.poziomStandardu = poziomStandardu;
        this.iloscOsob = iloscOsob;
        this.cenaZaDobe = cenaZaDobe;
    }
}
