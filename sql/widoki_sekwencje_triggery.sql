CREATE VIEW Hotelarz_Imie_Nazwisko AS
SELECT imie, nazwisko
FROM hotelarz;

CREATE VIEW Klient_Info AS
SELECT k.imie, k.nazwisko, k.numer_telefonu, k.`e-mail`, SUM(r.rachunek)
FROM klient k, rezerwacja r
WHERE k.ID = r.KlientID;


CREATE VIEW Klient_Rezerwacja_Pokoj AS
SELECT k.imie, k.nazwisko, r.data_przyj, r.data_wyj, r.rachunek, p.numer_pokoju, p.pietro
FROM klient k, rezerwacja r, pokoj p
WHERE k.ID = r.KlientID AND r.PokojID = p.ID;
