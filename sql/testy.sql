INSERT INTO administrator VALUES ('admin@wp.pl', 'aDmin1996');

INSERT INTO hotelarz (`e-mail`,haslo,imie,nazwisko,data_urodzenia)
VALUES ('jan.nowak@o2.pl', 'Janion2456','Jan','Nowak','1996-08-02');

INSERT INTO klient (HotelarzID, imie, nazwisko, numer_telefonu, `e-mail`, rodzaj_dokumentu, numer_dokumentu, jezyk)
VALUES (1, 'Ania', 'Kowalska', 678956790, 'ania.kowalska@onet.com', 'Paszport', 'AJHD245', 'polski');

INSERT INTO pokoj (KlientID, numer_pokoju, pietro, poziom_standardu, liczba_osob, cena_za_dobe)
VALUES (1, 3, 1, 8, 2, 250.00);

INSERT INTO rezerwacja VALUES (1,1,1, '2017-06-23', '2017-06-24', 280.00, 60.00, 2, 1);

SELECT * FROM administrator;
SELECT * FROM hotelarz;
SELECT * FROM klient;
SELECT * FROM pokoj;
SELECT * FROM rezerwacja;

UPDATE hotelarz
SET haslo = 'Password123'
WHERE ID = 1;

UPDATE klient
SET numer_telefonu = 123455678,  jezyk = 'angielski'
WHERE ID = 1;

UPDATE pokoj
SET poziom_standardu = 5, cena_za_dobe = 240.00
WHERE ID = 1;

UPDATE rezerwacja
SET data_wyj = '2017-06-26', rachunek = 560.00
WHERE KlientID = 1

DELETE FROM hotelarz
WHERE ID = 1;

DELETE FROM klient
WHERE ID = 1;

DELETE FROM pokoj
WHERE ID = 1;

DELETE FROM  rezerwacja
WHERE KlientID = 1
